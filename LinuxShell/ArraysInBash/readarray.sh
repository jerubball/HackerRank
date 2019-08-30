#!/bin/bash

# HackerRank LinuxShell ArraysInBash 1
# https://www.hackerrank.com/challenges/bash-tutorials-read-in-an-array/problem
# Author: Hasol

(( n=0 ))
declare -a arr

while read i
do
    arr[n]="$i"
    (( n++ ))
done

echo "${arr[*]}"
