// Created by cschalk on 4/14/16.
// Challenge 167 : Read More
#include <iostream>
#include <fstream>
using namespace std;

const string more = "... <Read More>";

string trim(const string &str, const string &space = " \t") {
    const auto strBegin = str.find_first_not_of(space);
    if (strBegin == std::string::npos)
        return ""; // no content

    const auto strEnd = str.find_last_not_of(space);
    const auto strRange = strEnd - strBegin + 1;

    return str.substr(strBegin, strRange);
}

int main(int argc, char ** argv) {
    ifstream input {argv[1]};
    string line;
    while (getline(input, line)) {
        if (line.length() > 55) {
            line = line.substr(0, 40);
            unsigned long lastSpace = line.find_last_of(" ");
            line = trim(line.substr(0, lastSpace));
            line += more;
        }
        cout << line << endl;
    }
}