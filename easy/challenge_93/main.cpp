// Created by cschalk on 3/21/16.
// Challenge 93 : Capitalize Strings
#include <iostream>
#include <fstream>
#include <locale>
#include <sstream>

using namespace std;

int main(int argc, char ** args) {
    std::ifstream input {args[1]};
    std::locale loc;
    std::string line;
    while (std::getline(input, line)) {
        std::string word;
        std::stringstream ss(line);
        while (ss >> word) {
            std::cout << std::toupper(word[0], loc);
            std::cout << word.substr(1, word.length() - 1);
            std::cout << " ";
        }
        std::cout << std::endl;
    }
    return 0;

}

