#!/bin/bash

# HackerRank LinuxShell Bash 5
# https://www.hackerrank.com/challenges/bash-tutorials---the-world-of-numbers/problem
# Author: Hasol

read x
read y

#echo $[ $x + $y ]
echo $(( x+y ))
echo $(( x-y ))
echo $(( x*y ))
echo $(( x/y ))
