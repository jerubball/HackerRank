#!/bin/bash

# HackerRank LinuxShell Bash 6
# https://www.hackerrank.com/challenges/bash-tutorials---comparing-numbers/problem
# Author: Hasol

read x
read y

#if (( x > y )) ; then echo "." ; fi

if [[ $x -gt $y ]]
then
    echo "X is greater than Y"
elif [[ $x -lt $y ]]
then
    echo "X is less than Y"
else
    echo "X is equal to Y"
fi
