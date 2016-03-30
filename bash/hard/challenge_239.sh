#!/bin/bash 
#
# Challenge 157: Maze Solver
# Created by cschalk 3/28/2016
#
################################

function partition() {
    local i=${1}
    local j=${2}
    local pivot=${array[${1}]}
    for (( ; ; )); do

        while [[ ${array[${j}]} -gt ${pivot} ]]; do 
	    ((j--))
	done

        while [[ ${array[${i}]} -lt ${pivot} ]]; do
	    ((i++))
	done
	  
	if (( i < j )); then
	    local tmp=${array[${i}]}
	    array[${i}]=${array[${j}]}
	    array[${j}]=${tmp}
	else
            retval=${j}
	    return;
	fi

    done
}

function quickSort {
    local left=${1}
    local right=${2}
    partition ${left} ${right}
    local index=${retval}
    ((pivots++))
    if (( left < (index - 1) )); then
	let "next = index - 1"
	quickSort ${left} ${next}
    fi

    if (( (index + 1) < right )); then
	let "prev = index + 1"
	quickSort ${prev} ${right}
    fi
}

################################################
### Script Entry Point
################################################


while read -r line || [[ -n ${line} ]]; do
    array=()
    IFS=" "
    for word in ${line}; do
	array+=(${word})
    done
     
    length=${#array[@]}
    let "end = length - 1"
    pivots=0
    quickSort 0 ${end}
    echo ${pivots};
done < ${1}
  
