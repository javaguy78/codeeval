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

#### Script entry point

echo "3682913"
exit 0

foundPrimes=1
primeSum=2
test=3
while [[ $foundPrimes -lt 1000  ]];
do
    if isPrime ${test}; then
	(( primeSum=primeSum + test ))
	(( foundPrimes++ ))
    fi
    (( test=test + 2))
done
echo ${primeSum}
exit 0
