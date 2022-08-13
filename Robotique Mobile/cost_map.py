# coding: utf-8

__author__ = "Remy Guyonneau"
__license__ = "GPL"
__email__ = "remy.guyonneau@univ-angers.fr"

import robot.pose

"""
    This file defines a CostCell class and a CostMap class
"""

from math import cos
from math import sin
from environment.grid_map import GridMap
from environment.grid_map import GridCell


class CostCell(GridCell):
    """ class to handle the cells of a cost map
    ATTRIBUTES:
        cost : (number) the cost of the cell
    """

    def __init__(self, x=0, z=0, cost=0):
        """ constructor of the class
        :param x: (int) x coordinate of the cell in the map
        :param z: (int) z coordinate of the cell in the map
        :param cost: (number) the cost of the cell
        """
        GridCell.__init__(self, x, z)
        self.cost = cost  # cost of the cell (distance to the closest obstacle)

    def __str__(self):
        """ to display a CostCell as a string"""
        return f"({self.x}, {self.z}, {self.cost})"


class CostMap(GridMap):
    """ class to handle a cost map
    ATTRIBUTES:
        max_cost: (number) maximal current cost of the cells
    """

    def __init__(self):
        """ constructor of the class
        """
        GridMap.__init__(self)
        self.max_cost = None  # -  maximal current cost of the cells

    def init_cost_map(self, grid_map):
        """ function to initialize the cost map according to a grid map
            :param grid_map: (environment.grid_map GridMap) a GridMap to compute the cost of
        """
        self.width = grid_map.width
        self.height = grid_map.height
        self.nb_cell_x = grid_map.nb_cell_x
        self.nb_cell_z = grid_map.nb_cell_z
        self.max_cost = 0

        self.cells = [[CostCell()]]
        self.cells.clear()
        for z in range(0, self.nb_cell_z):
            self.cells.append([])
            for x in range(0, self.nb_cell_x):
                c = CostCell()
                c.x = x
                c.z = z
                # if the cell corresponds to an obstacle, its cost is 0
                # otherwise the cost is initialized by +infinity
                if grid_map.cells[z][x].val == 1:
                    c.cost = 0
                else:
                    c.cost = float('inf')
                self.cells[z].append(c)

        self.size_x = self.width / self.nb_cell_x
        self.size_z = self.height / self.nb_cell_z


    def compute_cost_map(self, grid_map):
        """ function to compute the cost map from a grid map
        :param grid_map: (environment.grid_map GridMap)
        """
        self.init_cost_map(grid_map)
        self.max_cost = 0
        self.compute_north_west_2_south_east()
        self.compute_south_east_2_north_west()
        self.compute_south_west_2_north_east()
        self.compute_north_east_2_south_west()
        for z_cell in range(self.nb_cell_z):
            for x_cell in range(self.nb_cell_x):
                if self.cells[z_cell][x_cell].cost > self.max_cost:
                    self.max_cost = self.cells[z_cell][x_cell].cost


    def compute_north_west_2_south_east(self):
        """ function to compute the cells from the north west corner to the south east corner
        """
        for z_cell in range(0, self.nb_cell_z):
            for x_cell in range(0, self.nb_cell_x):
                if z_cell != 0:
                    if x_cell != 0:
                        tmp =  min(self.cells[z_cell - 1][x_cell - 1].cost + 2 , self.cells[z_cell][x_cell].cost)
                        self.cells[z_cell][x_cell].cost = tmp
                if z_cell != 0:
                    tmp =  min(self.cells[z_cell - 1][x_cell].cost + 1 , self.cells[z_cell][x_cell].cost)
                    self.cells[z_cell][x_cell].cost = tmp
                if x_cell != 0:
                    tmp =  min(self.cells[z_cell][x_cell - 1].cost + 1, self.cells[z_cell][x_cell].cost)
                    self.cells[z_cell][x_cell].cost = tmp
        pass



    def compute_south_east_2_north_west(self):
        """ function to compute the cells from the south east corner to the north west corner
        """
        for z_cell in reversed(range(0, self.nb_cell_z - 1)):
            for x_cell in reversed(range(0, self.nb_cell_x - 1)):
                if z_cell != self.nb_cell_z:
                    if x_cell != self.nb_cell_x:
                        tmp = min(self.cells[z_cell + 1][x_cell + 1].cost + 2, self.cells[z_cell][x_cell].cost)
                        self.cells[z_cell][x_cell].cost = tmp
                if z_cell != self.nb_cell_z:
                    tmp = min(self.cells[z_cell + 1][x_cell].cost + 1, self.cells[z_cell][x_cell].cost)
                    self.cells[z_cell][x_cell].cost = tmp
                if x_cell != self.nb_cell_x:
                    tmp =  min(self.cells[z_cell][x_cell + 1].cost + 1 , self.cells[z_cell][x_cell].cost)
                    self.cells[z_cell][x_cell].cost = tmp
        pass



    def compute_south_west_2_north_east(self):
        """ function to compute the cells the top to the bottom
        """
        for z_cell in reversed(range(-1, self.nb_cell_z - 1)):
            for x_cell in range(0, self.nb_cell_x):
                if z_cell != self.nb_cell_z:
                    if x_cell != 0:
                        tmp = min(self.cells[z_cell + 1][x_cell - 1].cost + 2 , self.cells[z_cell][x_cell].cost)
                        self.cells[z_cell][x_cell].cost = tmp
                if z_cell != self.nb_cell_z:
                    tmp = min( self.cells[z_cell + 1][x_cell].cost + 1, self.cells[z_cell][x_cell].cost)
                    self.cells[z_cell][x_cell].cost = tmp
                if x_cell != 0:
                    tmp =  min(self.cells[z_cell][x_cell - 1].cost + 1 , self.cells[z_cell][x_cell].cost)
                    self.cells[z_cell][x_cell].cost = tmp
        pass



    def compute_north_east_2_south_west(self):
        """ function to compute the cells from the north east corner to the south west corner
        """
        for z_cell in range(0,self.nb_cell_z - 1):
            for x_cell in reversed(range(-1, self.nb_cell_x - 1)):
                if z_cell != 0:
                    if x_cell != self.nb_cell_x:
                        tmp = min(self.cells[z_cell - 1][x_cell + 1].cost + 2 , self.cells[z_cell][x_cell].cost)
                        self.cells[z_cell][x_cell].cost = tmp
                if z_cell != 0:
                    tmp = min(self.cells[z_cell - 1][x_cell].cost + 1 , self.cells[z_cell][x_cell].cost)
                    self.cells[z_cell][x_cell].cost = tmp
                if x_cell != self.nb_cell_x:
                    tmp =  min(self.cells[z_cell][x_cell + 1].cost + 1 , self.cells[z_cell][x_cell].cost)
                    self.cells[z_cell][x_cell].cost = tmp
        pass



    def cell_is_empty(self, dx, dz):
        """ function to test if the cell corresponding to the dx and dz distances is empty or not
            dx and dz are coordinates in the environment
            PARAMETERS:
                dx: (number in m) x coordinate in the world frame
                dz: (number in m) z coordinate in the world frame
            RETURNS:
                True of False
        """

        if self.cells[int(dz / self.size_z)][int(dx / self.size_x)].cost == 0:
            return False
        else:
            return True

    def evaluate_cost(self, pose, measurements):
        """ function to evaluate the cost of measurements set according to the
            position x,z and the orientation theta
            parameters:
                pose: (robot.pose.Pose3D) the pose (x, z, theta)
                measurements: (list of LiDARMeasurement) the measurements
            return:
                cost: (number)
        """
        cost = 0

        for m in measurements:
            px = (pose.x + m.distance * cos(m.angle + pose.theta)) / self.size_x
            pz = (pose.z + m.distance * sin(m.angle + pose.theta)) / self.size_z

            if px < 0 or pz < 0 or px > self.nb_cell_x or pz > self.nb_cell_z:
                cost += self.max_cost
            else:
                cost += self.cells[int(pz)][int(px)].cost

        return cost
