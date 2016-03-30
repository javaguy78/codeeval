// Created by cschalk on 3/30/16.
// Challenge 15 : Endianness
#include <iostream>

int getBit(int val, int bit) {
    return (val & (1 << bit)) >> bit;
}


int main() {
    int test = 86;
    int test1 = getBit(test, 2);
    int test2 = getBit(test, 3);

    if (test1 == test2) {
        std::cout << "BigEndian" << std::endl;
    } else {
        std::cout << "LittleEndian" << std::endl;
    }

    return 0;
}
