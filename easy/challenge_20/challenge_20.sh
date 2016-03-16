#!/bin/bash
#
# Challenge 20: String to Lower Case
#
#############################################

while read -r testcase; do
    toLower=$(echo "${testcase}" | awk '{print tolower($0)}')
    echo ${toLower}
done < ${1}
