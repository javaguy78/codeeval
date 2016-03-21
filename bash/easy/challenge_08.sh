#!/bin/bash
#
# Challenge 08
# Reverse the order of words in input file
#############################################

function reverse {
    reversed=""
    for word in ${1}; do
	reversed="${word} ${reversed}"
    done
    echo "${reversed}"
}


#############################################
### SCRIPT ENTRY POINT
#############################################

while read -r sentence; do
    reverse "${sentence}"
done < ${1}
