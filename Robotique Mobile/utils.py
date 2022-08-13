# coding: utf-8

__author__ = "Remy Guyonneau"
__license__ = "GPL"
__email__ = "remy.guyonneau@univ-angers.fr"
""""
    This file contains function to implement
"""

from math import atan2
from math import sqrt
from math import pi


def follow_path(robot, path):
    """ function that allows the robot to follow the path
        it returns a command u to reach the next node, and update the path by
            removing the nodes that have been reached by the robot
        PARAMETERS:
            robot: (robot.robot.Robot) the robot (to get the current position)
            path: (list of tp_rrt.rrt_star.Node) the path to follow
        RETURNS:
            updated path: (list of tp_rrt.rrt_star.Node)
            wheel command: (list of 2 numbers: [left wheel speed, right wheel speed]
    """
    dst_min = 0.05
    u = [0, 0]
    # TODO
    right = [1, -1]
    left = [-1, 1]
    if len(path) > 1:
        _x = path[1].x - robot.pose.x
        _z = path[1].z - robot.pose.z
        _angle = atan2(_z,_x)
        while abs(_angle) > 2*pi:
            if _angle >= 0:
                _angle = _angle - 2*pi
            if _angle < 0:
                _angle = _angle + 2*pi
        angle = robot.pose.theta - _angle
        if abs(angle) > dst_min:
            if angle >= 0:
                U = left
            if angle < 0:
                U = right
        if abs(angle) <= dst_min:
            dist = sqrt(((robot.pose.z - path[1].z) ** 2) + ((robot.pose.x - path[1].x) ** 2))
            if dist > dst_min:
                U = [10, 10]
            else:
                print("Goal accomplished")
                path.pop(0)
    return path, u
