// Created by cschalk on 4/20/16.
// Challenge 214 : Time To Eat
#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>
#include <algorithm>
using namespace std;

struct {
    bool operator()(string a, string b) {
        stringstream ssa(a);
        stringstream ssb(b);
        int a1, a2, a3;
        int b1, b2, b3;
        char del;
        ssa >> a1 >> del >> a2 >> del >> a3;
        ssb >> b1 >> del >> b2 >> del >> b3;
        return (b1 < a1) || (b1 == a1 && b2 < a2) || (b1 == a1 && b2 == a2 && b3 < a3);
    }
} timeCompare;

void runChallenge(string line) {
    stringstream ss (line);
    string tstamp;
    vector<string> timestamps;
    while (ss >> tstamp) {
        timestamps.push_back(tstamp);
    }

    std::sort(timestamps.begin(), timestamps.end(), timeCompare);

    for (string stamp : timestamps) {
        cout << stamp << " ";
    }
    cout << endl;
}

int main(int argc, char ** argv) {
    ifstream input {argv[1]};
    string line;
    while (getline(input, line)) {
        runChallenge(line);
    }
}