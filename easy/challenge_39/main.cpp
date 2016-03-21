// Created by cschalk on 3/20/16.
// Challenge 39 : Happy Number
#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>

using namespace std;

std::vector<int> foundNumbers;

int sumOfDigitSquares(int in) {
    std::vector<int> digits;
    int sum = 0;
    while(in > 0) {
            digits.push_back(in % 10);
            sum += (digits.back() * digits.back());
            in /= 10;
        }
    return sum;
}

bool haveWeSeenThisNumberBefore(int number) {
    if (std::find(foundNumbers.begin(), foundNumbers.end(), number) != foundNumbers.end()) {
        return true;
    } else {
        foundNumbers.push_back(number);
        return false;
    }
}

int isHappy(int number) {
    if ( number == 1 ) {
        return 1;
    } else if ( haveWeSeenThisNumberBefore(number)) {
        return 0;
    }
    return isHappy(sumOfDigitSquares(number));
}

int main(int argc, char ** args) {
    std::ifstream input {args[1]};
    int number;

    while(input >> number) {
        std::cout << isHappy(number) << std::endl;
        foundNumbers.clear();
    }

}