// Created by cschalk on 4/11/16.
// Challenge 23 : 12x12 Multiplication Table
#include <iostream>
using namespace std;

string trim(const string &str, const string &space = " \t") {
    const auto strBegin = str.find_first_not_of(space);
    if (strBegin == std::string::npos)
        return ""; // no content

    const auto strEnd = str.find_last_not_of(space);
    const auto strRange = strEnd - strBegin + 1;

    return str.substr(strBegin, strRange);
}

string getLine(int in) {
    string toReturn = "";
    for (int i = 1; i <= 12 ; ++i) {
        string val = "    " + to_string(in * i);
        toReturn += val.substr(val.length() - 4, 4);
    }
    return toReturn;
}

int main() {
    for (int i = 1 ; i <= 12 ; ++i) {
        string line = getLine(i);
        cout << trim(line) << endl;
    }
}


