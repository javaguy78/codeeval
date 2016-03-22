// Created by cschalk on 3/20/16.
// Challenge 20 : Strings to lower.
#include <fstream>
#include <iostream>
#include <locale>

using namespace std;

int main(int argc, char ** args) {
    std::ifstream input {args[1]};
    std::locale loc;
    std::string line;

    while (std::getline(input, line)) {
        for (std::string::size_type i = 0 ; i < line.length() ; ++i ) {
            std::cout << std::tolower(line[i], loc);
        }
        std::cout << std::endl;
    }

    return 0;

}
