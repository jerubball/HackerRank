#!/bin/bash

# HackerRank LinuxShell TextProcessing 1
# https://www.hackerrank.com/challenges/text-processing-cut-1/problem
# Author: Hasol

while read i
do
    cut -c3 <<< $i
done
