#!/bin/bash
#
# Challenge 01: Fizz Buzz
#
################################

function fizzBuzz {
    divisor1=${1}
    divisor2=${2}
    count=${3}

    for digit in `seq 1 ${count}`; do
	let "remainder1 = ${digit} % ${divisor1}"
	let "remainder2 = ${digit} % ${divisor2}"
	if [[ ${remainder1} -eq 0 ]] && [[ ${remainder2} -eq 0 ]]; then
	    echo -n "FB "
	elif [[ ${remainder1} -eq 0 ]]; then
	    echo -n "F "
	elif [[ ${remainder2} -eq 0 ]]; then
	    echo -n "B "
	else
	    echo -n "${digit} "
	fi
    done
    echo ""
}

###############################
## Script Entry Point
###############################

if [[ ! -z ${1} ]]; then
    while read line
    do
	fizzBuzz ${line}
    done < ${1}
fi
