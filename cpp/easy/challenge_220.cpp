// Created by cschalk on 5/19/16.
// Challenge 220 : Trick or Treat
#include <iostream>
#include <fstream>
#include <sstream>
using namespace std;

struct group {
    int vampires;
    int zombies;
    int witches;
    int houses;
};

int get_value(const string in) {
    unsigned long index = in.find(',');
    string textVal = in.substr(0, index);
    return atoi(textVal.c_str());
}

int get_candy(group in) {
    int toReturn = 0;
    toReturn += ((3 * in.vampires) * in.houses);
    toReturn += ((4 * in.zombies) * in.houses);
    toReturn += ((5 * in.witches) * in.houses);

    int total_kids = in.vampires + in.zombies + in.witches;
    return toReturn / total_kids;
}

void run_challenge(string line) {
    group g;
    stringstream s(line);
    string key;
    while (s >> key) {
        string value;
        s >> value;
        if (key.compare("Vampires:") == 0) {
            g.vampires = get_value(value);
        } else if (key.compare("Zombies:") == 0) {
            g.zombies = get_value(value);
        } else if (key.compare("Witches:") == 0) {
            g.witches = get_value(value);
        } else if (key.compare("Houses:") == 0) {
            g.houses = get_value(value);
        }
    }

    cout << get_candy(g) << endl;
}

int main(int argc, char** argv) {
    ifstream input {argv[1]};
    string line;
    while (getline(input, line)) {
        run_challenge(line);
    }
}