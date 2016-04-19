// Created by cschalk on 4/17/16.
// Challenge 237 : Panacea - Truth or Lie
#include <iostream>
#include <fstream>
#include <sstream>
using namespace std;

unsigned int get_sum(string const &v, int base) {
    unsigned int toReturn = 0;
    string val;
    stringstream ss(v);
    while (ss >> val) {
        toReturn += strtoull(val.c_str(), nullptr, base);
    }
    return toReturn;
}

void runChallenge(string const &line) {
    unsigned long token = line.find("|");
    auto virus = get_sum(line.substr(0, token), 16);
    auto antivirus = get_sum(line.substr(token + 1, string::npos), 2);
    cout << ((antivirus >= virus) ? "True" : "False") << endl;
}

int main(int argc, char ** argv) {
    ifstream input {argv[1]};
    string line;
    while (getline(input, line)) {
        runChallenge(line);
    }
    return 0;
}