// Created by cschalk on 4/11/16.
// Challenge 208 : Find the highest score
#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>
using namespace std;

int main(int argc, char ** argv) {
    ifstream inFile {argv[1]};
    string line;

    while (getline(inFile, line)) {
        vector<int> highScores;
        int index = line.find_first_of("|");
        string bracket = line.substr(0, index);
        line = line.substr(index + 1, string::npos);

        // read initial scores
        stringstream values (bracket);
        int value;
        while (values >> value) {
            highScores.push_back(value);
        }

        // Compare rest of values
        while(line.length() != 0) {
            index = line.find_first_of("|");
            if (index == -1) {
                bracket = line;
                line = "";
            } else {
                bracket = line.substr(0, index);
                line = line.substr(index + 1, string::npos);
            }

            stringstream values(bracket);
            for (int i = 0; i < highScores.size(); ++i) {
                values >> value;
                if (value > highScores[i]) {
                    highScores[i] = value;
                }
            }
        }

        for (int i : highScores) {
            cout << i << " ";
        }
        cout << endl;
    }

}

