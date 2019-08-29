#!/bin/bash

# HackerRank LinuxShell TextProcessing 9
# https://www.hackerrank.com/challenges/text-processing-cut-9/problem
# Author: Hasol

while read i
do
    cut -f2- <<< $i
done
