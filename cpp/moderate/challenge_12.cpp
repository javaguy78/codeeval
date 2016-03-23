// Created by cschalk on 3/22/16.
// Challenge 12 : First non duplicate letter
#include <fstream>
#include <iostream>
#include <vector>
#include <algorithm>

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
            if (std::find(foundDuplicates.begin(), foundDuplicates.end(), line[i]) == foundDuplicates.end()) {
                if (std::find(foundLetters.begin(), foundLetters.end(), line[i]) == foundLetters.end()) {
                    foundLetters.push_back(line[i]);
                } else {
                    foundLetters.erase(std::remove(foundLetters.begin(), foundLetters.end(), line[i]), foundLetters.end());
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


