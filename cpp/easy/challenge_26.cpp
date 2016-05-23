// Created by cschalk on 5/16/16.
// Challenge 26 - File Size
#include <iostream>
#include <fstream>

int main(int argc, char ** argv) {
    std::ifstream input(argv[1], std::ifstream::ate | std::ifstream::binary);
    std::cout << input.tellg() << std::endl;
}

