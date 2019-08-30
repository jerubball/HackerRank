#!/bin/bash

# HackerRank LinuxShell ArraysInBash 6
# https://www.hackerrank.com/challenges/bash-tutorials-count-the-number-of-elements-in-an-array/problem
# Author: Hasol

arr=( $(cat) )
echo "${#arr[@]}"
