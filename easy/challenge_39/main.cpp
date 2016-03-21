// Created by cschalk on 3/20/16.
// Challenge 39 : Happy Number
#include <iostream>
#include <fstream>
#include <stack>
using namespace std;

std::stack<int> foundNumbers;

int sumOfDigitSquares(int in) {
    std::stack<int> digits;
    int sum = 0;
    while(in > 0) {
            digits.push(in % 10);
            sum += (digits.top() * digits.top());
            in /= 10;
        }
    return sum;
}

bool haveWeSeenThisNumberBefore(int number) {
    std::stack<int> looped;
    while(!foundNumbers.empty()) {
        if (number == foundNumbers.top()) {
            return true;
        } else {
            looped.push(foundNumbers.top());
            foundNumbers.pop();
        }
    }
    looped.push(number);
    foundNumbers = looped;
    return false;
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
        while(!foundNumbers.empty()) { // clean out found numbers;
            foundNumbers.pop();
        }
    }

}