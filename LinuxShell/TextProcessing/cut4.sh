#!/bin/bash

# HackerRank LinuxShell TextProcessing 4
# https://www.hackerrank.com/challenges/text-processing-cut-4/problem
# Author: Hasol

while read i
do
    cut -c1-4 <<< $i
    #echo ${i:0:4}
done
