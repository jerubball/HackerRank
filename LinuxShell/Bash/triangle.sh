#!/bin/bash

# HackerRank LinuxShell Bash 8
# https://www.hackerrank.com/challenges/bash-tutorials---more-on-conditionals/problem
# Author: Hasol

read x
read y
read z

if [[ $x -eq $y && $y -eq $z ]]
then
    echo "EQUILATERAL"
elif [[ $x -eq $y || $y -eq $z || $z -eq $x ]]
then
    echo "ISOSCELES"
else
    echo "SCALENE"
fi
