#!/bin/bash

# HackerRank LinuxShell ArraysInBash 5
# https://www.hackerrank.com/challenges/bash-tutorials-display-the-third-element-of-an-array/problem
# Author: Hasol

arr=( $(cat) )
echo "${arr[3]}"
