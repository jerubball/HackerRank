#!/bin/bash

# HackerRank LinuxShell ArraysInBash 4
# https://www.hackerrank.com/challenges/bash-tutorials-concatenate-an-array-with-itself/problem
# Author: Hasol

arr=( $(cat) )
arr1=( "${arr[@]}" "${arr[@]}" "${arr[@]}" )

echo "${arr1[@]}"
