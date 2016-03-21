#!/usr/bin/env bash
#
# Challenge 205: Clean Up Words
#
#################################

function trim {
  local s2 s="$*"
  # note the tab character in the expressions of the following two lines when copying
  until s2="${s#[   ]}"; [ "$s2" = "$s" ]; do s="$s2"; done
  until s2="${s%[   ]}"; [ "$s2" = "$s" ]; do s="$s2"; done
  echo "$s"
}

##############################
## Script entry point
##############################

while read -r line || [[ -n ${line} ]]; do
    cleaned=$(trim $(echo "${line}" | sed 's/[^a-zA-Z]/ /g' | sed 's/[[:space:]]\+/ /g'))
    echo $(echo "${cleaned}" | awk '{print tolower($0)}')
done < ${1}