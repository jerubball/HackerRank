#!/bin/bash

# HackerRank LinuxShell Bash 10
# https://www.hackerrank.com/challenges/bash-tutorials---compute-the-average/problem
# Author: Hasol

read n
(( avg=0 ))

for (( i=0; i<n; i++ ))
do
    read x
    (( avg += x ))
done

printf "%.3f" $(bc -l <<< "$avg / $n")
