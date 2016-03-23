// Created by cschalk on 3/22/16.
// Challenge 12 : First non duplicate letter
#include <fstream>
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

template<typename T, typename U>
inline bool contains(T const &t, U const &u) {
    auto result = std::find(t.begin(), t.end(), u);
    return result != t.end();
}

template<typename T, typename U>
inline void remove(T &t, U const &u) {
    t.erase(std::remove(t.begin(), t.end(), u), t.end());
}

int main(int argc, char ** args) {
    std::ifstream input {args[1]};
    std::string line;

    std::vector<char> foundDuplicates;
    std::vector<char> foundLetters;
    while (std::getline(input, line)) {
        foundDuplicates.clear();
        foundLetters.clear();
        for (std::string::size_type i = 0 ; i < line.length() ; ++i ) {
            if (!contains(foundDuplicates, line[i])) {
                if (!contains(foundLetters, line[i])) {
                    foundLetters.push_back(line[i]);
                } else {
                    remove(foundLetters, line[i]);
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


