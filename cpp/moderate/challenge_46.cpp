// Created by cschalk on 3/30/16.
// Challenge 46 : Primes less than n
#include <iostream>
#include <fstream>
#include <cmath>

bool isPrime(int in) {
    switch (in) {
        case 1  : return false;
        case 2  : return true;
        default : {
            if (in % 2 == 0) {
                return false;
            }
            int limit = (int) std::sqrt(in) + 1;
            for (int i = 3 ; i < limit; i+=2) {
                if (in % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}

int main(int argc, char ** argv) {
    std::ifstream input {argv[1]};
    int test;

    while (input >> test) {
        if (test >= 2) {
            std::cout << 2;
        }

        if (test > 2) {
            for (int i = 3 ; i < test ; i+=2) {
                if (isPrime(i)) {
                    std::cout << "," << i;
                }
            }
        }
        std::cout << std::endl;
    }
    return 0;
}
