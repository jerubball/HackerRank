#!/bin/bash

# HackerRank LinuxShell GrepSedAwk 14
# https://www.hackerrank.com/challenges/awk-2/problem
# Author: Hasol

awk '{
    state = "Pass"
    for ( i = 2; i <= NF; i++ ) {
        if ( $i < 50 ) {
            state = "Fail";
        }
    }
    print $1,":",state;
}'
