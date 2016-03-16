#!/bin/bash
#
# Challenge 22 : Nth fibonacci number
# 
#############################################

function printNthFibDigit {
    digit=${1}
    if [[ ! -z digit ]]; then
	case ${digit} in 
	    0|1) echo ${digit} ;;
            2)   echo "1"      ;;
	    *)
		A1=1
		A2=1
		for iteration in $(/usr/bin/seq 4 ${digit}); do
		    TMP=$((A1 + A2))
		    A1=${A2}
		    A2=${TMP}
		done
		echo $((A1 + A2))
		;;
	esac
    fi
}

#########################
## Script Entry Point
#########################

while read -r testcase; do
    if [[ ${testcase} != "" ]]; then
	printNthFibDigit ${testcase}
    fi
done < ${1}
