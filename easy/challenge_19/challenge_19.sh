#!/bin/bash
#
# Challenge 19: binary bits are equal
#
#############################################

while read -r line; do
    int=$(echo "${line}" | /usr/bin/awk -F, '{print $1}')
    bit1=$(echo "${line}" | /usr/bin/awk -F, '{print $2}')
    bit2=$(echo "${line}" | /usr/bin/awk -F, '{print $3}')
    binary=$( echo "obase=2;${int}" | /usr/bin/bc | rev)
    if [[ ${binary:$((bit1 - 1)):1} == ${binary:$((bit2 - 1)):1} ]]; then
	echo "true"
    else
	echo "false"
    fi
done < ${1}
