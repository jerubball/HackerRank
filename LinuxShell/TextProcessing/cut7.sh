#!/bin/bash

# HackerRank LinuxShell TextProcessing 7
# https://www.hackerrank.com/challenges/text-processing-cut-7/problem
# Author: Hasol

while read i
do
    cut -d" " -f4 <<< $i
done
