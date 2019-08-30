#!/bin/bash

# HackerRank LinuxShell ArraysInBash 8
# https://www.hackerrank.com/challenges/lonely-integer-2/problem
# Author: Hasol

read n
arr=( "$(cat)" )

sort -n <<< "$(for i in ${arr[@]}; do echo $i; done)" | uniq -u
