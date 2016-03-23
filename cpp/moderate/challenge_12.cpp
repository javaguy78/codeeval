// Created by cschalk on 3/22/16.
// Challenge 12 : First non duplicate letter
#include <fstream>
#include <iostream>
#include <vector>
#include <algorithm>

#define CONTAINS(x, y) (std::find(x.begin(), x.end(), y) != x.end())
#define REMOVE(x, y) (x.erase(std::remove(x.begin(), x.end(), y), x.end()))

using namespace std;

int main(int argc, char ** args) {
    std::ifstream input {args[1]};
    std::string line;

    std::vector<char> foundDuplicates;
    std::vector<char> foundLetters;
    while (std::getline(input, line)) {
        foundDuplicates.clear();
        foundLetters.clear();
        for (std::string::size_type i = 0 ; i < line.length() ; ++i ) {
            if (!(CONTAINS(foundDuplicates, line[i]))) {
                if (!(CONTAINS(foundLetters, line[i]))) {
                    foundLetters.push_back(line[i]);
                } else {
                    REMOVE(foundLetters, line[i]);
                    foundDuplicates.push_back(line[i]);
                }
            }
        }
        if (!foundLetters.empty()) {
            std::cout << foundLetters.front() << std::endl;
        }
    }

    return 0;

}


