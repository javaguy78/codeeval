#!/usr/bin/env bash
#
# Challenge 93: Capitalize Strings
#
###################################

function trim {
  local s2 s="$*"
  # note the tab character in the expressions of the following two lines when copying
  until s2="${s#[   ]}"; [ "$s2" = "$s" ]; do s="$s2"; done
  until s2="${s%[   ]}"; [ "$s2" = "$s" ]; do s="$s2"; done
  echo "$s"
}

###################################
### Script Entry Point
###################################

while read -r testCase; do
    sentence=""
    IFS=" "
    for word in ${testCase}; do
        word=$(tr '[:lower:]' '[:upper:]' <<< ${word:0:1})${word:1}
        sentence+="${word} "
    done
    echo $(trim ${sentence})
done < ${1}