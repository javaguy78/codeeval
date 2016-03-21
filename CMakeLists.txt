cmake_minimum_required(VERSION 3.3)
project(codeeval)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

function (challenge difficulty val)
    add_executable(challenge_${val} codeeval/${difficulty}/challenge_${val}/main.cpp)
endfunction(challenge)

challenge(easy 01) # FizzBuzz
challenge(easy 03) # Prime Palendrome
challenge(easy 04) # Prime Sums
challenge(easy 08) # Reverse Strings
challenge(easy 18) # First Multiple Larger than X
challenge(easy 19) # Bit Positions
challenge(easy 20) # Strings to lower
challenge(easy 21) # Sum of Digits
challenge(easy 22) # Nth Fibonacci Digit
challenge(easy 25) # Odd Numbers
