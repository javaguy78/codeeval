// Created by cschalk on 4/6/16.
// Challenge 113 : Multiply Lists
#include <iostream>
#include <fstream>
#include <sstream>

using namespace std;

void multiplySets(const string &set1, const string &set2) {
    stringstream sset1(set1);
    stringstream sset2(set2);
    int one, two;
    while (sset1 >> one) {
        sset2 >> two;
        cout << one * two << " ";
    }
    cout << endl;
}

int main(int argc, char ** argv) {
    ifstream input {argv[1]};
    string line;
    while (getline(input, line)) {
        int token = line.find_first_of('|');
        string set1 = line.substr(0, token++);
        string set2 = line.substr(token, line.length() - token);
        multiplySets(set1, set2);
    }
}

