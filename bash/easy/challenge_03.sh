#!/bin/bash

function isPrime {
    ip_test=${1}
    case ${ip_test} in 
        1) return 1 ;;
        2) return 0 ;;
        *)
            # Get rid of evens without looping
            let "even = ${ip_test} % 2"
            if [[ ${even} -eq 0 ]]; then
                return 1
            fi

            # Effeciently loop through odds with only odd divisors
            ip_sqrt=$(echo "sqrt (${ip_test}) +1" | bc)
            for (( mod=3 ; mod < ip_sqrt ; mod+=2 ))
            do
                let "remainder = ${ip_test} % ${mod}"
                if [[ ${remainder} -eq 0 ]]; then
                    return 1
                fi
            done
            return 0
            ;;
    esac
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
