# coding: utf-8

__author__ = "Remy Guyonneau"
__license__ = "GPL"
__email__ = "remy.guyonneau@univ-angers.fr"

import random

"""
    This file provides a Particle class and a MonteCarloLocalization Class
"""

from math import cos
from math import pi
from math import sin
from random import gauss
from random import uniform
from robot.pose import Pose3D
import copy as copy


class Particle:
    """ class to handle the particle of the monte carlo localization algorithm
    ATTRIBUTES:
        self.pose: (robot.pose.Pose3D)  pose of the particle (x, z, theta)
        self.weight: (number) weight of the particle
    """

    def __init__(self, pose=Pose3D(), weight=0.0):
        """ constructor of the class
            :param pose: (robot.pose.Pose3D)  pose of the particle (x, z, theta)
            :param weight: (number) weight of the particle
        """
        self.pose = copy.copy(pose)  # (robot.pose.Pose3D)  pose of the particle (x, z, theta) in meter
        self.weight = weight  # (number)   weight of the particle

    def __str__(self):
        """ to display a Particle as a string"""
        return f"{self.pose} : {self.weight}"

    def __eq__(self, other):
        """
        Overwrite the == operator
        :param other: (Particle) the Particle to be compared with
        """
        if other is None:
            return False
        else:
            return self.pose == other.pose

    def __lt__(self, other):
        """"
        """
        return self.weight < other.weight

    def __le__(self, other):
        """"
        """
        return self.weight <= other.weight

    def __gt__(self, other):
        """"
        """
        return self.weight > other.weight

    def __ge__(self, other):
        """"
        """
        return self.weight >= other.weight


class MonteCarloLocalization:
    """ class to handle the Monte Carlo Localization
    ATTRIBUTES:
        self.particles: (list of Particle) the particles
        self.nb_particles: (int) number of particles
        self.max_weight: (number) current maximal weight of a particle
        self.bestParticle: (Particle) currently best particle
    """

    def __init__(self):
        """ constructor of the class
        """
        self.particles = []  # List of the particles
        self.nb_particles = 0  # number of particles
        self.max_weight = 0.0  # current maximal weight of a particle
        self.id_best_particle = None  # currently best particle (should be an index in the particles list)

    def init_particles(self, cost_map, number_of_particles):
        """ function that initialises the particles
            the cost map is needed because we do not want to put particles in
            a non obstacle free cell
            the particles are uniformly spread over the map
            :param cost_map: (environment.cost_map.CostMap) the cost map
            :param number_of_particles: (int) the number of particles
        """
        self.nb_particles = number_of_particles
        self.particles = []
        self.max_weight = 0

        prob = uniform(0.0, 2 * pi)
        for k in range(0, self.nb_particles):
            x_cell = uniform(0.0, cost_map.width)
            z_cell = uniform(0.0, cost_map.height)
            while cost_map[int(z_cell)][int(x_cell)].cost == 0:
                x_cell = uniform(0.0, cost_map.width)
                z_cell = uniform(0.0, cost_map.height)
            self.particles.append(Particle(Pose3D(x_cell, z_cell, prob), 1 / self.nb_particles))
            if self.max_weight < 1 / self.nb_particles:
                self.max_weight = 1 / self.nb_particles

    def __str__(self):
        """
        To display a MonteCarloLocalization as a string (debug propose)
        """
        msg = ""
        for p in self.particles:
            msg += str(p) + "\n"
        return msg

    def evaluate_particles(self, cost_map, measurements):
        """ function that update the particles weight according to the measurements
            and the cost map
            note that the max weight and the best particle need to be computed and
            the weight needs to be normalize (between 0 and 1)
            :param cost_map: (environment.cost_map.CostMap) the cost map
            :param measurements: (list of robot.lidar.LiDARMeasurement) the measurements
        """
        maximum_cost = 0
        maximum_weight = 0
        position_optimal = 0
        sommation_weight = 0
        for particle in self.particles:
            particle.weight = cost_map.evaluate_cost(particle.pose, measurements)
            maximum_cost = max(particle.weight, maximum_cost)
        for particle in self.particles:
            particle.weight = maximum_cost - particle.weight
            sommation_weight += particle.weight
        for k in range(len(self.particles)):
            self.particles[k].weight /= sommation_weight
            if maximum_weight < self.particles[k].weight:
                maximum_weight = self.particles[k].weight
                position_optimal = k
        self.id_best_particle = position_optimal
        self.max_weight = maximum_weight
        pass


    def re_sampling(self, sigma_xz=0.05, sigma_theta=1 * pi / 180):

        step = 1 / self.nb_particles
        k = 0
        cost = uniform(0, step)
        sommation_Cost= self.particles[k].weight

        for particle in range(self.nb_particles):

            while cost > sommation_Cost:
                k += 1
                sommation_Cost += self.particles[k].weight

            if particle != self.id_best_particle:
                particle_x = gauss(self.particles[k].pose.x, sigma_xz)
                particle_z = gauss(self.particles[k].pose.z, sigma_xz)
                particle_t = gauss(self.particles[k].pose.theta, sigma_theta)

                self.particles[particle].pose = Pose3D(particle_x, particle_z, particle_t)
                self.particles[particle].weight = self.particles[k].weight

            cost += step
        pass

    def estimate_from_odometry(self, odo_delta_dst, odo_delta_theta):
        """ function that update the position and orientation of all the particles
            according to the odometry data
            PARAMETERS:
                odo_delta_dst: (number) the distance delta
                odo_delta_theta: (number) the orientation delta
        """

        for particle in range(0 , len(self.particles)):
            self.particles[particle].pose.x += cos(self.particles[particle].pose.theta) * odo_delta_dst
            self.particles[particle].pose.z += sin(self.particles[particle].pose.theta) * odo_delta_dst
            self.particles[particle].pose.theta += odo_delta_theta
        pass

    def add_random_particles(self, cost_map, percent):
        """ function that modifies "percent" percent of particles by initializing them
            randomly
            percent is a value between 0 and 100
            PARAMETERS:
                cost_map: (CostMap) the cost map
                percent: (int) the percent (from 0 to 100)
        """
        randPart = 0
        numberParts = 0
        doneParts = []

        while randPart < percent:
            i = int(uniform(0, self.nb_particles))
            while i == self.id_best_particle or doneParts.__contains__(i):
                i = int(uniform(0, self.nb_particles))

            x = int(uniform(0, cost_map.width))
            z = int(uniform(0, cost_map.height))
            while cost_map[z][x].cost == 0:
                x = int(uniform(0, cost_map.width))
                z = int(uniform(0, cost_map.height))

            theta = uniform(0, 2 * pi)

            self.particles[i].pose = Pose3D(x, z, theta)

            numberParts += 1
            randPart = (numberParts / self.nb_particles) * 100
            doneParts.append(i)

        pass
