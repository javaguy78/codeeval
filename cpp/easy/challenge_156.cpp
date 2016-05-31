// Created by cschalk on 5/31/16.
// Challenge 156 - RoLlErCoAsTeR tExT
#include <iostream>
#include <fstream>
using namespace std;

void run_challenge(const string line) {
    bool capitalize = true;
    for (char c : line) {
        if (isalnum(c)) {
            if (capitalize) {
                putchar(toupper(c));
                capitalize = false;
            } else {
                putchar(tolower(c));
                capitalize = true;
            }
        } else {
            cout << c;
        }
    }
    cout << endl;
}

int main(int argc, char** argv) {
    ifstream input{argv[1]};
    string line;
    while(getline(input, line)) {
        run_challenge(line);
    }
}

