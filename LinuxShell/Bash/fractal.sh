#!/bin/bash

# HackerRank LinuxShell Bash 11
# https://www.hackerrank.com/challenges/fractal-trees-all/problem
# Author: Hasol

function str_repeat { # char $1, uint $2
    str=""
    for (( i=0; i<$2; i++))
    do
        str+="$1"
    done
    echo $str
}

function str_replace { # string $1, char $2, uint $3
    echo "${1:0:$3-1}$2${1:$3}"
}

read n

# prep
blankline=$(str_repeat "_" 100)  #"
for i in {1..63}
do
    arr[i]="$blankline"
done

# work
(( lengthX=${#blankline} ))
(( lengthY=${#arr[*]} ))
(( centerX=(lengthX)/2))
for (( i=0; i<n; i++ ))
do
    (( amount=2**i ))
    (( sizeY=((lengthY+1)/(amount*2)) ))
    (( halfY=sizeY/2 ))

    (( startX=centerX ))
    for (( j=0; j<i; j++ ))
    do
        (( startX-=(lengthY+1)/(2**(j+2)) ))
    done
    # iteration
    for (( j=0; j<amount; j++ ))
    do
        # vertical
        for (( k=0; k<halfY; k++ ))
        do
            (( index=sizeY+halfY+k ))
            #arr[index]="${arr[$index]:0:$centerX-1}1${arr[$index]:$centerX}"
            arr[index]=$(str_replace "${arr[$index]}" "1" $startX)
        done
        # slanting
        for (( k=1; k<=halfY; k++ ))
        do
            (( index=sizeY+halfY-k ))
            arr[index]=$(str_replace "${arr[$index]}" "1" $(( startX-k )) )
            arr[index]=$(str_replace "${arr[$index]}" "1" $(( startX+k )) )
        done
        (( startX+=sizeY*2 ))
    done
done

# show
for i in ${arr[@]}
do
    echo "$i"
done
