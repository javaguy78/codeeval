#!/bin/bash
#
# Challenge 157: Maze Solver
#
################################

function readMaze {

    while read -r line || [[ -n ${line} ]]; do
        WIDTH=${#line}
        MAZE="${MAZE}${line}"
    done < ${1}
  
    LENGTH=${#MAZE}
    HEIGHT=$(( LENGTH / WIDTH)) # | bc)
    START=$(echo "${MAZE}" | grep -aob ' ' | awk -F: '{print $1}' | head -n 1)
    END=$(echo "${MAZE}" | grep -aob ' ' | awk -F: '{print $1}' | tail -n 1)
}

function solve {
    cells[${START}]="0:${START}"
    PATH=(${START})
    
    while [[ ! -z ${PATH[@]} ]]; do
        coord=${PATH[0]}
        PATH=("${PATH[@]:1}")
        if [[ ! -z ${coord} ]]; then
            divine ${coord}
        fi
    done
}

function divine {
    coord=${1}

    nextx=$((coord + 1))
    update ${nextx} ${coord}

    prevx=$((coord - 1))
    update ${prevx} ${coord}

    nexty=$((coord + WIDTH))
    update ${nexty} ${coord}
    
    prevy=$((coord - WIDTH))
    update ${prevy} ${coord}
}

function getScore {
    scoreCoord=${1}
    scoreString=${cells[${scoreCoord}]}
    echo ${scoreString} | /usr/bin/awk -F':' '{ print $1 }'
}

function getCoordinate {
    coordCoord=${1}
    coordString=${cells[${coordCoord}]}
    echo "${coordString}" | /usr/bin/awk -F: '{print $2}'
}

function update {
    nextCoord=${1}
    currentCoord=${2}
    currentScore=$(getScore ${currentCoord})
 
    if [[ ${nextCoord} -gt 0 ]] && [[ ${nextCoord} -lt ${#MAZE} ]]; then
        char=${MAZE:${nextCoord}:1}
        if [[ "${char}" == " " ]]; then
            nextCell=${cells[${nextCoord}]}
            nextScore=$((currentScore + 1))
            if [[ -z ${nextCell} ]]; then
                cells[${nextCoord}]="${nextScore}:${currentCoord}"
                PATH+=(${nextCoord})
            else
                oldScore=$(getScore ${nextCoord})
                if [[ ${nextScore} -lt ${oldScore} ]]; then
                    cells[${nextCoord}]="${nextScore}:${currentCoord}"
                fi
            fi
        fi
    fi
}

function writeAnswer {
    writeCoord=${END}
    while [[ ${writeCoord} -gt ${START} ]]; do
        MAZE="${MAZE:0:${writeCoord}}+${MAZE:$((writeCoord+1))}"
        writeCoord=$(getCoordinate ${writeCoord})
    done
}

function printMaze {
    for row in $(/usr/bin/seq 0 ${HEIGHT}); do
        echo "${MAZE:((row * WIDTH)):${WIDTH}}"
    done 
}

################################
## SCRIPT ENTRY POINT
################################

readMaze ${1}
solve
writeAnswer
printMaze
