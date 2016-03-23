# Created by cschalk on 3/21/16.
cmake_minimum_required(VERSION 3.3)
project(codeeval)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

function (challenge difficulty val)
    add_executable(challenge_${val} ${difficulty}/challenge_${val}.cpp)
endfunction(challenge)

challenge(easy 01)  # FizzBuzz
challenge(easy 03)  # Prime Palendrome
challenge(easy 04)  # Prime Sums
challenge(easy 08)  # Reverse Strings
challenge(easy 18)  # First Multiple Larger than X
challenge(easy 19)  # Bit Positions
challenge(easy 20)  # Strings to lower
challenge(easy 21)  # Sum of Digits
challenge(easy 22)  # Nth Fibonacci Digit
challenge(easy 25)  # Odd Numbers
challenge(easy 39)  # Happy Numbers
challenge(easy 93)  # Capitalize Strings
challenge(easy 205) # Clean Up Words

challenge(moderate 12) # First Non Duplicate Letter