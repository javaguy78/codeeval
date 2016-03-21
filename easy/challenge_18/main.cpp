// Created by cschalk on 3/17/16.
// Challenge 18 : first multiple larger than x
#include <iostream>
#include <fstream>
using namespace std;

void firstMultipleLargerThanX(int test, int summer, int multiple ) {
    if (test <= summer) {
        std::cout << summer << std::endl;
    } else {
        firstMultipleLargerThanX(test, summer + multiple, multiple);
    }
}

int main(int argc, char ** argv) {

    std::ifstream input {argv[1]};
    int test, multiple;
    char gulp;

    while (input >> test >> gulp >> multiple) {
        firstMultipleLargerThanX(test, multiple, multiple);
    }

    return 0;
}

