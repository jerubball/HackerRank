#!/bin/bash

# HackerRank LinuxShell TextProcessing 27
# https://www.hackerrank.com/challenges/text-processing-in-linux-the-uniq-command-3/problem
# Author: Hasol

#uniq -ci
uniq -c -i | cut -c7-
