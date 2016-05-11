// Created by cschalk on 4/20/16.
// Challenge 183 : Details
#include <iostream>
#include <fstream>
#include <climits>
#include <algorithm>
using namespace std;

char delim = ',';
char empty = '.';

int runChallenge(string &line) {
    string row;
    int a = INT_MAX;
    while (!line.empty()) {
        if(line.find("XY") != string::npos) {
            return 0;
        }
        unsigned long index = line.find(delim);
        if (index > line.length()) {
            index = line.length();
        }
        row = line.substr(0, index);
        int c = count(row.begin(), row.end(), empty);
        a = min(a, c);
        line.erase(0, index+1);
    }
    return a;
}

int main(int argc, char ** argv) {
    ifstream input {argv[1]};
    string line;
    while (getline(input, line)) {
        int a = runChallenge(line);
        cout << a << endl;
    }
}




