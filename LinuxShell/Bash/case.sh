#!/bin/bash

# HackerRank LinuxShell Bash 7
# https://www.hackerrank.com/challenges/bash-tutorials---getting-started-with-conditionals/problem
# Author: Hasol

read i

case $i in
[Yy])
    echo "YES";;
[Nn])
    echo "NO";;
esac
