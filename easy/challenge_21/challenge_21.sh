#!/bin/bash
#
# Challenge 21 : Sum of digits in a number
# 
#############################################

while read -r testcase; do
    length=${#testcase}
    sum=0
    for index in $(/usr/bin/seq 0 ${length}); do
	digit=${testcase:${index}:1}
	sum=$(( sum + digit))
    done
    echo ${sum}
done < ${1}
