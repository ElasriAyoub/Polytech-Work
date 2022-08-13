# coding: utf-8

__author__ = "Remy Guyonneau"
__license__ = "GPL"
__email__ = "remy.guyonneau@univ-angers.fr"
"""
    This file provides a Node class and a RRT_Star class
"""

from geometry.point import Point2D
from geometry.segment import Segment2D
from math import sqrt, atan2, cos, sin
import random as random


class Node:
    """ class to handle Nodes in the RRT
    ATTRIBUTES:
        self.x: (number in m) x position of the node in the world frame
        self.z: (number in m) z position of the node in the world frame
        self.cost: (number) cost of the node (distance from this node to the root node)
        self.parent: (int) id of the parent node in the tree
        self.id: (int) id of the node, correspond to the index of the node in the tree list
    """

    def __init__(self, x_coord, z_coord):
        """ constructor of the class
            PARAMETERS:
                x_coord: (number in m) x position of the node in the world frame
                z_coord: (number in m) z position of the node in the world frame
        """
        self.x = x_coord     # value of the node
        self.z = z_coord     # value of the node
        self.cost = None     # cost of the node (distance from this node to the initial one)
        self.parent = None   # direct parent of the node in the graph
        self.id = None       # id of the node

    @staticmethod
    def dist(n1, n2):
        """ static function that returns the euclidean distance between two nodes
        PARAMETERS:
            n1: (Node) first node
            n2: (Node) second node
        RETURNS:
            the distance (number)
        """
        return sqrt((n1.x-n2.x)**2 + (n1.z-n2.z)**2)

    @staticmethod
    def step_from_to(n1, n2, epsilon):
        """ static function that returns a new node at an epsilon distance of
            the node n1 in the direction of the node n2
        PARAMETERS:
            n1: (Node) first node (the "from" node)
            n2: (Node) second node (the "to" node)
            epsilon: (number in m) the maximal distance of the new node to the "from" node
        RETURNS:
            the new node (Node)
        """
        # TODO
        pt_one = Point2D(n1.x, n1.z)
        pt_two = Point2D(n2.x, n2.z)

        if (Point2D.distance(pt_one, pt_two) >= epsilon):
            x = n1.x + epsilon * cos(atan2(n2.z - n1.z, n2.x - n1.x))
            z = n1.z + epsilon * sin(atan2(n2.z - n1.z, n2.x - n1.x))
            return Node(x, z)

        if (Point2D.distance(pt_one, pt_two) < epsilon):
            return n2

    def __str__(self):
        """ function to print a node
        """
        return f"[ ({self.x},{self.z}), {self.cost}, {self.parent} ]"

    def __eq__(self, other):
        """ function to test is two nodes are equals (only position) """
        return self.x == other.x and self.z == other.z


class RRTStar:
    """ class to handle Rapidly Random Tree
    ATTRIBUTES:
        self.nodes: (list of Node) nodes of the graph
        self.path: (list of Node) path to go to the goal node from the start node
        self.epsilon: (number in m) distance step for the creation of new node
        self.start: (geometry.point.Point2D) the starting point2D for the graph
        self.goal: (geometry.point.Point2D) the point2D goal
        self.succeed: (bool) to indicates if the tree has been built correctly or not
    """

    def __init__(self):
        """ constructor of the class
        """
        self.nodes = []       # nodes of the graph
        self.path = []        # path to go to the goal node from the start node

        self.start = None     # the starting point2D for the graph
        self.goal = None      # the point2D goal
        self.succeed = False  # to indicates if the tree has been built correctly or not

        self.epsilon = 0.5                  # distance step to generate a new node in the graph
        self.max_nodes = 1000               # maximal number of nodes for the tree
        self.radius = 0.3                   # radius inside which we are looking for a better parent
        self.max_distance = 0.2             # maximal distance to consider that we have reached the target
        self.rand_nodes_before_target = 50  # number of random nodes before considering the target as random node

    def choose_parent(self, my_map, nearest, node):
        """ function to choose a parent to the node "node" according to the map
        PARAMETERS:
            node: (Node) the node we want to find the best parent
            my_map: (environment.seg_map.SegMap) the map we are creating the graph in
            nearest: (Node) the nearest node according to the euclidean distance
        RETURN:
            the updated node "node"
        """
        # TODO
        chosen_parent = nearest

        for chosen_node in self.nodes:
            dist = Node.dist(node, chosen_node)
            dist_cost_node = chosen_node.cost + Node.dist(chosen_node, node)
            dist_cost_parent = chosen_parent.cost + Node.dist(chosen_parent, node)

            if (dist < self.radius) and (self.trajectory_free(my_map, node, chosen_node)) and dist_cost_parent > dist_cost_node:
                chosen_parent = chosen_node

        node.parent = chosen_parent.id
        node.cost = chosen_parent.cost + Node.dist(node, chosen_parent)

        return node

    @staticmethod
    def trajectory_free(my_map, start, goal):
        """ function to test if the trajectory from the node start to the node goal
            does not intersect any obstacle in the map
            PARAMETERS:
                my_map: (environment.seg_map.SegMap) the known map
                start: (Node) the starting node
                goal: (Node) the target node
            RETURN:
                True or False
        """
        # TODO
        for i in range(len(my_map.obstaclesSeg)):
            if Segment2D.does_intersect(Segment2D(start, goal), my_map.obstaclesSeg[i]) == True:
                return False
        return True

    @staticmethod
    def get_rand_node(my_map):
        """ function that returns a random node in the map
        PARAMETERS:
            my_map: (environment.seg_map.SegMap) the known map
        RETURN:
            a random node (Node)
        """
        # TODO
        return Node(random.uniform(0, my_map.width), random.uniform(0, my_map.height))

    def build_rrt(self, my_map, start, goal):
        """ function that build an RRT, according to a start position, a goal position and
            a map (set of segments)
            PARAMETERS:
                my_map: (environment.seg_map.SegMap) the known map
                start: (geometry.point.Point2D) the starting point for the tree
                goal: (geometry.point.Point2D) the target point (position)
        """
        self.start = start      # the starting point2D for the graph
        self.goal = goal        # the point2D goal
        self.path = []          # the set of nodes to go from the start to the goal
        self.succeed = False    # to flag if the rrt is successful or not (if the target has been reached or not)
        self.nodes = []         # we remove the previous graph

        # TODO

        start = Node(start.x, start.z)
        start.id = 0
        start.cost = 0
        self.nodes.append(start)
        goal = Node(goal.x, goal.z)

        i = 1
        j = 0

        while (len(self.nodes) < self.max_nodes) and (self.succeed == False):
            nearest = self.nodes[i - 1]
            flag = False
            if (j % self.rand_nodes_before_target) == 0:
                node_new = goal
            if (j % self.rand_nodes_before_target) != 0:
                node_new = RRTStar.get_rand_node(my_map)

            for node in self.nodes:
                if (Node.dist(node_new, nearest) >= Node.dist(node_new, node)) and (RRTStar.trajectory_free(my_map, node, node_new)):
                    nearest = node
                    flag = True

            if flag == True:
                step = Node.step_from_to(nearest, node_new, self.epsilon)
                step = self.choose_parent(my_map, nearest, step)
                step.id = i
                self.nodes.append(step)

                if (Node.dist(step, goal) <= self.max_distance):
                    self.succeed = True
                    if not step.x == goal.x or step.z == goal.z:
                        goal = self.choose_parent(my_map, step, goal)
                        goal.id = i + 1
                        self.nodes.append(goal)
                i = i + 1

            j = j + 1

    def compute_path(self):
        """ function that compute a path in the tree to go from the starting node
            to the goal node
        """
        # TODO
        temp = self.nodes[::-1][0]
        self.path = []
        self.path.append(temp)

        while temp.parent is not None:
            temp = self.nodes[temp.parent]
            self.path.append(temp)
        self.path = self.path[::-1]


    def improve_path(self, my_map):
        """ function to improve the computed path by removing nodes that are not necessary
            (free trajectory)
            PARAMETERS:
                my_map: (environment.seg_map.SegMap) the known map
        """
        # TODO
        for x, node_one in enumerate(self.path):
            for node_two in self.path[x + 2:]:
                if (self.trajectory_free(my_map, node_one, node_two) == True):
                    self.path.pop(x + 1)
                if (self.trajectory_free(my_map, node_one, node_two) == False):
                    break

    def clear(self):
        """ function to remove the previous path and graph
        """
        self.path.clear()
        self.nodes.clear()

    def __str__(self):
        """ function convert a RTTStar into a string
        """
        ret_str = ""
        for i, n in enumerate(self.nodes):
            ret_str += f"{i} : {n}\n"
        return ret_str
