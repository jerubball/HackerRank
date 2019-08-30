#!/bin/bash

# HackerRank LinuxShell GrepSedAwk 13
# https://www.hackerrank.com/challenges/awk-1/problem
# Author: Hasol

awk '{
    if ( NF < 4 ) {
        print "Not all scores are available for",$1
    }
}'
