// Created by cschalk on 5/17/16.
// Challenge 29 - Unique Numbers
#include <iostream>
#include <fstream>
#include <sstream>
using namespace std;

const char delimiter = ',';

void runChallenge(string line) {
    stringstream elements(line);
    string output;
    int elem;

    while (elements >> elem) {
        unsigned long index = output.find(std::to_string(elem));
        if (index > output.length()) {
            if (output.length() > 0) {
                output += delimiter;
            }
            output += std::to_string(elem);
        }
    }

    cout << output << endl;
}

string remove_delimiters(string line) {
    unsigned long index = line.find(delimiter);
    while (index < line.length()) {
        line.replace(index, 1, " ");
        index = line.find(delimiter);
    }
    return line;
}

int main (int argc, char** argv) {
    ifstream input {argv[1]};
    string line;
    while (getline(input, line)) {
        line = remove_delimiters(line);
        runChallenge(line);
    }
}
