// Created by cschalk on 3/20/16.
// Challenge 21 : Sum of digits in a number
#include <fstream>
#include <iostream>

using namespace std;

int sumOfDigits(int in) {
    int sum = 0;
    while ( in > 0 ) {
        sum += in % 10;
        in /= 10;
    }
    return sum;
}

int main(int argc, char ** args) {
    std::ifstream input {args[1]};
    int number;
    while(input >> number) {
        std::cout << sumOfDigits(number) << std::endl;
    }

    return 0;

}


