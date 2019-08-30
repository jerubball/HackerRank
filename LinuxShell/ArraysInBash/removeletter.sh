#!/bin/bash

# HackerRank LinuxShell ArraysInBash 7
# https://www.hackerrank.com/challenges/bash-tutorials-remove-the-first-capital-letter-from-each-array-element/problem
# Author: Hasol

arr=( $(cat) )
echo "${arr[@]/#[A-Z]/.}"
