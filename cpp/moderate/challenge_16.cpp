// Created by cschalk on 3/30/16.
// Challenge 16 : Number of ones
#include <iostream>
#include <fstream>
#include <bitset>

int main(int argc, char ** argv) {
    std::ifstream input {argv[1]};
    int test;

    while (input >> test) {
        std::string binary = std::bitset<64>(test).to_string();
        int count = 0;
        for (char c : binary) {
            if (c == '1') {
                count++;
            }
        }
        std::cout << count << std::endl;
    }

    return 0;
}
