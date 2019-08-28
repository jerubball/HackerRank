#!/bin/bash

# HackerRank LinuxShell Bash 9
# https://www.hackerrank.com/challenges/bash-tutorials---arithmetic-operations/problem
# Author: Hasol

read e

printf "%.3f\n" $(bc -l <<< $e)
#bc <<< "scale=3; $e"
