// Created by cschalk on 3/21/16.
// Challenge 205 : Clean Up Words
#include <iostream>
#include <fstream>
#include <locale>
#include <queue>

using namespace std;

int main(int argc, char ** args) {
    std::ifstream input {args[1]};
    std::string line;
    while (std::getline(input, line)) {
        line += " "; // to get last word
        std::queue<string> foundWords;
        std::locale loc;
        std::string foundWord = "";
        for (std::string::size_type i = 0 ; i < line.length() ; ++i) {
            if (isalpha(line[i])) {
                foundWord += std::tolower(line[i], loc);
            } else {
                if (foundWord.length() > 0) {
                    foundWords.push(foundWord);
                    foundWord = "";
                }
            }
        }

        while (!foundWords.empty()) {
            std::cout << foundWords.front();
            foundWords.pop();
            if (!foundWords.empty()) {
                std::cout << " ";
            }
        }
        std::cout << std::endl;
    }
    return 0;
}

