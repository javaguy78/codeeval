#!/bin/bash

function isPrime {

    ip_test=${1}
    if [[ ${ip_test} -eq 1 ]]; then 
	return 1 
    fi
    if [[ ${ip_test} -eq 2 ]]; then 
	return 0 
    fi
    ip_sqrt=$(echo "sqrt (${ip_test})" | bc)
    ((ip_sqrt++))
    for mod in `seq 2 ${ip_sqrt}`
    do
	let " remainder = $ip_test % $mod "
	if [[ ${remainder} -eq 0 ]]; then
	    return 1
	fi
    done
    return 0

}

function isPalindrome {

    palTest=${1}
    palRev=""
    for ch in `seq 0 ${#palTest}`
    do
	palRev="${palTest:${ch}:1}${palRev}"
    done
    if [[ ${palTest} == ${palRev} ]]; then
	return 0
    fi
    return 1

}

#### Script entry point

test=1000
while [[ $test -gt 0 ]];
do
    if isPrime ${test}; then
	if isPalindrome ${test}; then
	    echo ${test}
	    exit 0
       fi
   fi
    (( test=test - 1))
done

exit 1
