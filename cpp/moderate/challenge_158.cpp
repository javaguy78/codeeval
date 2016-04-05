// Created by cschalk on 4/2/16.
// Challenge 158 : Interrupted Bubble Sort;
#include <iostream>
#include <fstream>
#include <vector>
#include <sstream>

using namespace std;

vector<int> parseSet(string setString) {
    vector<int> toReturn;
    stringstream ss(setString);
    int input;
    while (ss >> input) {
        toReturn.push_back(input);
    }
    return toReturn;
}

void runChallenge(string setString, long loops) {
    vector<int> set = parseSet(setString);
    long setSize = set.size();
    loops = min(setSize, loops);

    // Bubble Sort
    for (long i = 0 ; i < loops ; i++) {
        for (long j = 0 ; j < set.size() - 1; j++) {
            if (set[j] > set[j+1]) {
                int tmp = set[j];
                set[j] = set[j + 1];
                set[j + 1] = tmp;
            }
        }
    }

    for (int i : set) {
        cout << i << " ";
    }
    cout << endl;
}

int main (int argc, char ** argv) {
    ifstream input {argv[1]};
    string line;
    while(getline(input, line)) {
        int setTerminator = line.find_first_of('|');
        string setString = line.substr(0, setTerminator);
        line = line.substr(setTerminator + 1, line.length() - setTerminator);
        long loops = stol(line);

        runChallenge(setString, loops);
    }
    return 0;
}

