#!/bin/bash
#
# Challenge 39 : Happy Numbers
# 
#############################################

function haveWeSeenThisNumberBefore {
    for number in ${SEEN_LIST[@]}; do
        if [[ ${number} -eq ${1} ]]; then
            return 0
        fi
    done
    SEEN_LIST+=(${1})
    return 1
}

function isHappyNumber {

    if [[ ${1} -eq 1 ]]; then
        echo "1"
    elif haveWeSeenThisNumberBefore ${1}; then
        echo "0"
    else
        next=0
        limit=${#1}
        for (( index=0 ; index < limit ; index++ )); do
            digit=${1:${index}:1}
            next=$(( next + (digit * digit)));
        done
        isHappyNumber ${next}
    fi
}

###############################
### Script Entry
###############################

while read -r testcase; do
    SEEN_LIST=()
    isHappyNumber ${testcase}
done < ${1}
