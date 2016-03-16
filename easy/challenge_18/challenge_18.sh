#!/bin/bash
#
# Challenge 08
# Reverse the order of words in input file
#############################################

function checkNGreaterThanX {
    if [[ ${1} -gt ${checkx} ]]; then
	echo ${1}
    else
	checkn=$((checkn + multiple))
	checkNGreaterThanX ${checkn}
    fi
}

#############################################
### SCRIPT ENTRY POINT
#############################################

while read -r line; do
    checkx=$(echo "${line}" | /usr/bin/awk -F, '{print $1}')
    checkn=$(echo "${line}" | /usr/bin/awk -F, '{print $2}')
    multiple=${checkn}
    checkNGreaterThanX ${checkn}
done < ${1}
