#!/bin/bash
#
# Challenge 12 : first non duplicated letter
# Created by cschalk on 3/23/2016
#
############################################

function firstNonRepeatedCharacter {
    letters=""
    duplicate=""
    word=${1}
    length=${#word}
    for (( CHAR=0 ; CHAR < length ; CHAR++ )); do
	char=${word:${CHAR}:1}
	result=$(echo ${duplicate} | grep ${char})
	if [[ $? -ne 0 ]]; then
	    result=$(echo ${letters} | grep ${char})
	    if [[ $? -ne 0 ]]; then
		letters=${letters}${char}
	    else
		letters=$(echo ${letters} | sed "s/"${char}"//g")
		duplicate=${duplicate}${char}
	    fi
	fi
    done

    if [[ ! -z ${letters} ]]; then
	echo ${letters:0:1}
    fi
}

############################################
### SCRIPT ENTRY POINT
############################################


while read line || [[ -n "$line" ]]; do
    firstNonRepeatedCharacter $line
done < $1
