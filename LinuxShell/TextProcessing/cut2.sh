#!/bin/bash

# HackerRank LinuxShell TextProcessing 2
# https://www.hackerrank.com/challenges/text-processing-cut-2/problem
# Author: Hasol

while read i
do
    cut -c2,7 <<< $i
done
