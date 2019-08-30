#!/bin/bash

# HackerRank LinuxShell GrepSedAwk 10
# https://www.hackerrank.com/challenges/text-processing-in-linux-the-sed-command-3/problem
# Author: Hasol

sed -E -e 's/\b(thy)\b/{\1}/gi'
#sed -e 's/thy/{&}/gi'
