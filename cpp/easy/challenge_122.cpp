// Created by cschalk on 5/31/16.
// Challenge 122 - Hidden Numbers
#include <iostream>
#include <fstream>
using namespace std;

void run_challenge(const string line) {
    string result;
    for (char c : line) {
        if (isdigit(c)) {
            result += c;
        } else {
            switch(c) {
                case 'a' : result += '0'; break;
                case 'b' : result += '1'; break;
                case 'c' : result += '2'; break;
                case 'd' : result += '3'; break;
                case 'e' : result += '4'; break;
                case 'f' : result += '5'; break;
                case 'g' : result += '6'; break;
                case 'h' : result += '7'; break;
                case 'i' : result += '8'; break;
                case 'j' : result += '9'; break;
                default: continue;
            }
        }
    }

    if (result.empty()) {
        result = "NONE";
    }

    cout << result << endl;
}

int main(int argc, char** argv) {
    ifstream input{argv[1]};
    string line;
    while(getline(input, line)) {
        run_challenge(line);
    }
}


