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
challenge(easy 23)  # 12x12 Multiplication Table
challenge(easy 24)  # Sum of numbers in a file
challenge(easy 25)  # Odd Numbers
challenge(easy 39)  # Happy Numbers
challenge(easy 93)  # Capitalize Strings
challenge(easy 113) # Multiply Lists
challenge(easy 140) # Data Recovery
challenge(easy 167) # Read More
challenge(easy 205) # Clean Up Words
challenge(easy 208) # Find the highest score
challenge(easy 235) # Simple or Trump
challenge(easy 237) # Panacea - Truth or Lie
challenge(easy 240) # Mersenne Numbers less than x

challenge(moderate 12)  # First Non Duplicate Letter
challenge(moderate 15)  # Endianness
challenge(moderate 16)  # Number of Ones
challenge(moderate 27)  # Decimal to Binary
challenge(moderate 46)  # Primes less than X
challenge(moderate 89)  # Pass Triangle
challenge(moderate 158) # Interrupted Bubble Sort

challenge(hard 52)  # Text Dollars
challenge(hard 157) # The Labyrinth
challenge(hard 239) # Quick as a flash
