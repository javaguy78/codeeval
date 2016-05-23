// Created by cschalk on 5/19/16.
// Challenge 199: String mask
#include <iostream>
#include <fstream>
#include <sstream>

void run_challenge(std::string line) {
    std::stringstream in(line);
    std::string word;
    std::string mask;
    in >> word >> mask;

    for (int i = 0; i < word.length(); ++i) {
        if (mask.at(i) == '1') {
            putchar(std::toupper(word.at(i)));
        } else {
            putchar(word.at(i));
        }
    }

    std::cout << std::endl;
}

int main(int argc, char** argv) {
    std::ifstream input {argv[1]};
    std::string line;
    while(std::getline(input, line)) {
        run_challenge(line);
    }
}

