#!/bin/bash

# HackerRank LinuxShell TextProcessing 1
# https://www.hackerrank.com/challenges/text-processing-cut-1/problem
# Author: Hasol

#cut -c3

while read i
do
    cut -c3 <<< $i
    #echo "${i:2:1}"
done
