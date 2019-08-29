#!/bin/bash

# HackerRank LinuxShell TextProcessing 3
# https://www.hackerrank.com/challenges/text-processing-cut-3/problem
# Author: Hasol

while read i
do
    cut -c2-7 <<< $i
done
