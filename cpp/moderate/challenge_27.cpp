// Created by cschalk on 3/30/16.
// Challenge 27: Decimal to Binary
#include <iostream>
#include <fstream>
#include <bitset>

int main(int argc, char ** argv) {
    std::ifstream input {argv[1]};
    int test;

    while (input >> test) {
        if (test > 0) {
            std::string binary = std::bitset<64>(test).to_string();
            int index = binary.find_first_of('1');
            std::cout << binary.substr(index, binary.length() - index) << std::endl;
        } else {
            std::cout << 0 << std::endl;
        }
    }
    return 0;
}
