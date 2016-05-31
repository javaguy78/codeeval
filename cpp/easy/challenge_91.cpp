// Created by cschalk on 5/31/16.
// Challenge 91 : Simple Sort
#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>
#include <algorithm>
using namespace std;

void run_challenge(const string line) {
    stringstream in (line);
    string elem;
    vector<double> my_doubles;
    while (in >> elem) {
        double dub = stod(elem);
        my_doubles.push_back(dub);
    }

    std::sort(my_doubles.begin(), my_doubles.end());

    cout.precision(3);

    for (double d : my_doubles) {
        cout << fixed << d << " ";
    }
    cout << endl;
}

int main(int argc, char** argv) {
    ifstream input{argv[1]};
    string line;
    while (getline(input, line)) {
        run_challenge(line);
    }
}

