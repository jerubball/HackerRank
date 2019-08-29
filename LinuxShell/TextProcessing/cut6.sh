#!/bin/bash

# HackerRank LinuxShell TextProcessing 6
# https://www.hackerrank.com/challenges/text-processing-cut-6/problem
# Author: Hasol

while read i
do
    cut --characters="13-" <<< $i
done
