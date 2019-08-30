#!/bin/bash

# HackerRank LinuxShell ArraysInBash 3
# https://www.hackerrank.com/challenges/bash-tutorials-filter-an-array-with-patterns/problem
# Author: Hasol

(( n=0 ))
declare -a arr

while read i
do
    arr[n]="$i"
    (( n++ ))
done

echo ${arr[@]//*a*/}
