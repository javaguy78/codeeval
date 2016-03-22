// Created by cschalk on 3/21/16.
// Challenge 01 : Fizz Buzz
#include <iostream>
#include <fstream>

using namespace std;

void FizzBuzz(int divisor1, int divisor2, int digits) {
    for (int count = 1 ; count <= digits ; count++) {
        if (count % divisor1 == 0) {
            std::cout << 'F';
            if (count % divisor2 == 0) {
                std::cout << 'B';
            }
        } else if (count % divisor2 == 0) {
            std::cout << 'B';
        } else {
            std::cout << count;
        }
        std::cout << ' ';
    }
    std::cout << std::endl;
}

int main(int argc, char ** argv) {

    std::ifstream input {argv[1]};
    int div1, div2, digits;

    // firstLine
    input >> div1 >> div2 >> digits;
    while (input) {
        FizzBuzz(div1, div2, digits);
        input >> div1 >> div2 >> digits;
    }
    return 0;
}
