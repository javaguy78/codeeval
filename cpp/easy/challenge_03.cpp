// Created by cschalk on 3/21/16.
// Challenge 03 : Largest prime palindrome less than 1000
#include <iostream>
#include <math.h>
using namespace std;

bool isPrime(int test) {
    switch(test) {
        case 1  : return false;
        case 2  : return true;
        default : {
            // get rid of evens first
            if (test % 2 == 0) return false;

            // test only odd divisors in the loop
            auto root = sqrt(test) + 1;
            for (auto mod = 3; mod < root; mod += 2) {
                if (test % mod == 0) return false;
            }
            return true;
        }
    }
}

bool isPalindrome(int input) {
    std::string test = std::to_string(input);
    for (unsigned long i = 0, j = test.length() - 1 ; i < j ; i++, j-- ) {
        if (test[i] != test[j]) {
            return false;
        }
    }
    return true;
}

int main(int argc, char ** argv) {
    for (int i = 1000; i > 0 ; i--) {
        if (isPrime(i)) {
            if (isPalindrome(i)) {
                std::cout << i << std::endl;
		return 0;
            }
        }
    }
    return 1;
}
