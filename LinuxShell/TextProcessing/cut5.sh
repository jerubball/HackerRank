#!/bin/bash

# HackerRank LinuxShell TextProcessing 5
# https://www.hackerrank.com/challenges/text-processing-cut-5/problem
# Author: Hasol

while read i
do
    cut -f1-3 <<< $i
done
