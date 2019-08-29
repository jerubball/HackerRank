#!/bin/bash

# HackerRank LinuxShell TextProcessing 8
# https://www.hackerrank.com/challenges/text-processing-cut-8/problem
# Author: Hasol

while read i
do
    cut --delimiter=" " --fields="-3" <<< $i
done
