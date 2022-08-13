# coding: utf-8

__author__ = "Remy Guyonneau"
__license__ = "GPL"
__email__ = "remy.guyonneau@univ-angers.fr"
""""
    This file contains function to implement
"""

from math import atan2
from math import pi, sqrt


def follow_path(robot, a_star):
    """ function that allows the robot to follow the path computed in the A*
        it returns a command u to reach the next node, and update the path of the A* by
            removing the nodes that have been reached by the robot
        PARAMETERS:
            robot: (robot.robot.Robot) the robot (to get the current position)
            a_star: (tp_a_star.astar.AStar) the A* with the path to follow
        RETURNS:
            wheel command: (list of 2 numbers: [left wheel speed, right wheel speed])
    """
    u = [0, 0]
    # TODO
    return u
