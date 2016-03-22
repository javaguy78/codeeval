// Created by cschalk on 3/21/16.
// Challenge 04 : Sum of first 1000 primes
#include <iostream>
#include <math.h>

int sum = 2;
int primes = 1;

bool isPrime(int test) {
    switch (test) {
        case 1  : return false;
        case 2  : return true;
        default : {
            if (test % 2 == 0) {
                return false;
            } else {
                auto root = sqrt(test) + 1;
                for (auto i = 3; i < root; i++) {
                    if (test % i == 0) return false;
                }
                return true;
            }
        }
    }
}

int main(int argc, char **argv) {
    int number = 3;
    do {
        if (isPrime(number)) {
            sum += number;
            primes++;
        }
        number+=2;
    } while (primes < 1000);

    std::cout << sum << std::endl;
    return 0;
}