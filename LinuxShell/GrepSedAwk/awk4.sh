#!/bin/bash

# HackerRank LinuxShell GrepSedAwk 2
# https://www.hackerrank.com/challenges/awk-4/problem
# Author: Hasol

awk '{
    if ( NR % 2 == 1) {
        printf $0 ";";
    } else {
        printf $0 "\n";
    }
}'
