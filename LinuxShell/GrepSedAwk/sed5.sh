#!/bin/bash

# HackerRank LinuxShell GrepSedAwk 12
# https://www.hackerrank.com/challenges/sed-command-5/problem
# Author: Hasol

sed -E -e 's/([0-9]+) ([0-9]+) ([0-9]+) ([0-9]+)/\4 \3 \2 \1/'
