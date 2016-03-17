#!/bin/bash
#
# Challenge 25: Print only odd numbers to stdout
#
################################################

LIMIT=100
for (( count=1 ; count <  LIMIT ; count+=2 )); do
    echo ${count}
done
