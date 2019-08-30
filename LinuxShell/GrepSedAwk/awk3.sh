#!/bin/bash

# HackerRank LinuxShell GrepSedAwk 1
# https://www.hackerrank.com/challenges/awk-3/problem
# Author: Hasol

awk '{
    sum = 0;
    for ( i = 2; i <= NF; i++ ) {
        sum += $i;
    }
    avg = sum / (NF - 1);
    grade = "";
    if ( avg >= 80 ) {
        grade = "A";
    } else if ( avg >= 60 ) {
        grade = "B";
    } else if ( avg >= 50 ) {
        grade = "C";
    } else {
        grade = "FAIL";
    }
    print $0,":",grade;
}'
