# coding: utf-8

__author__ = "Remy Guyonneau"
__license__ = "GPL"
__email__ = "remy.guyonneau@univ-angers.fr"
"""
    This file provides an AStar class (A* algorithm)
"""

from tp_a_star.node import Node
from geometry.point import Point2D
from math import pow
from math import sqrt


class AStar:
    """ class to handle the A* algorithm
    ATTRIBUTES:
        self.nodes: (list of tp_a_star.node.Node) the nodes of the A*
        self.path: (list of geometry.point.Point2D) the path to go from the starting point to the target
        self.nb_z: (int) the number of cells in the x-axis
        self.nb_x: (int) the number of cells in the z-axis
        self.sizeX: (number in m) the size of a cell in the x-axis
        self.sizeZ: (number in m) the size of a cell in the z-axis
        self.width: (number in m) the total width of the map (environment, grid)
        self.height: (number in m) the total height of the map (environment, grid)
        self.opened: (list of tp_a_star.node.Node) the opened list to store all the opened nodes
        self.closed: (list of tp_a_star.node.Node) the closed list to store all the opened nodes
        self.start: (geometry.point.Point2D) the starting point for the shortest path (index in the grid)
        self.target: (geometry.point.Point2D) the target/goal for the shortest path (index in the grid)
    """

    def __init__(self, grid_map):
        """ class to handle the A* algorithm
        PARAMETERS:
            grid_map: (environment.grid_map.GridMap) the grid map we want to compute path in
        """
        self.nodes = [[Node()]]                 # List of nodes
        self.path = []                  # List of positions (Point2D)
        self.nb_z = grid_map.nb_cell_z  # number of cells in the x-axis
        self.nb_x = grid_map.nb_cell_x  # number of cells in the z-axis
        self.sizeX = grid_map.size_x    # m : size of a cell in the x-axis
        self.sizeZ = grid_map.size_z    # m : size of a cell in the z-axis
        self.width = grid_map.width     # m : total width of the map (environment, grid)
        self.height = grid_map.height   # m : total height of the map (environment, grid)
        # initialization of the grid of nodes
        #   z first then the x
        self.nodes.clear()
        for z in range(0, self.nb_z):
            self.nodes.append([])
            for x in range(0, self.nb_x):
                # The grid is a 2D array of nodes (defined in node.py)
                c = Node()                  # each cell corresponds to a node
                c.position = Point2D(x, z)  # updating the actual position of the node (position in the grid, index)
                # initialization of the costs
                c.s_cost = float('inf')
                c.h_cost = float('inf')
                c.f_cost = float('inf')
                # update the cell as walkable (not an obstacle) or not (not walkable => an obstacle in the map)
                if grid_map.cells[z][x].val == 1:
                    c.walkable = False
                else:
                    c.walkable = True
                # the initialized node is added to the grid
                self.nodes[z].append(c)
        self.opened = []         # the opened list to store all the opened nodes
        self.closed = []         # the closed list to store all the opened nodes
        self.start = Point2D()   # the starting point for the shortest path (index in the grid)
        self.target = Point2D()  # the target/goal for the shortest path (index in the grid)

    def reset(self):
        """ reset function to reset the A* (the values of the nodes)
        """
        for z in range(0, self.nb_z):
            for x in range(0, self.nb_x):
                # for all the set, the costs are reset
                self.nodes[z][x].s_cost = float('+inf')
                self.nodes[z][x].h_cost = float('+inf')
                self.nodes[z][x].f_cost = float('+inf')
                # the attributes of the nodes are reset
                self.nodes[z][x].is_opened = False
                self.nodes[z][x].is_closed = False
                self.nodes[z][x].is_path = False
        # and the lists are emptied
        self.closed.clear()
        self.opened.clear()
        self.path.clear()

    def find_path(self, start_pos, target_pos):
        """ The A* algorithm, find the shortest path in the grid from start to target
            PARAMETERS:
                start_pos : (geometry.point.Point2D) the starting cell (indexes of the grid)
                target_pos : (geometry.point.Point2D) the target cell (indexes of the grid)
        """
        self.reset()  # reset the A* first, just in case

        # set the starting point and the target
        self.start = start_pos
        self.target = target_pos

        # TODO



    def get_world_coordinates_from_index(self, index):

        world = Point2D()

        world.x = index.x * self.sizeX + self.sizeX/2

        world.z = index.z * self.sizeZ + self.sizeZ/2

        return world  # returns the new Point2D

    def update_node(self, pos_parent, dx, dz):

        new_position = Point2D()

        new_position.x = pos_parent.x + dx

        new_position.z = pos_parent.z + dz

        if self.nodes[new_position.z][new_position.x].walkable == True:

            if  (dz == 1 or dz == -1) and (dx == -1 or dx == 1):

                new_position_s_cost = self.nodes[pos_parent.z][pos_parent.x].s_cost + 14

            else:

                new_position_s_cost = self.nodes[pos_parent.z][pos_parent.x].s_cost + 10

            new_position_h_cost = self.heuristic(new_position)

            self.nodes[new_position.z][new_position.x].update_costs(new_position_s_cost, new_position_h_cost, pos_parent)

            self.nodes[new_position.z][new_position.x].is_opened = True

        pass

    def heuristic(self, position):

        Distance = Point2D.distance(self.target, position)

        return (Distance*10)
