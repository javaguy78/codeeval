// Created by cschalk on 5/22/16.
// Challenge 222 : The Black Spot
#include <iostream>
#include <fstream>
#include <vector>
#include <sstream>
using namespace std;

vector<string> get_players(string players) {
    vector<string> toReturn;
    stringstream in(players);
    string name;
    while (in >> name) {
        toReturn.push_back(name);
    }
    return toReturn;
}

void run_challenge(string line) {
    unsigned long pipe_index = line.find('|');
    vector<string> players = get_players(line.substr(0, pipe_index));
    int turns = atoi(line.substr(pipe_index + 1, string::npos).c_str());

    while(players.size() > 1) {
        int indexToRemove = turns % players.size();
        if (indexToRemove == 0) {
            players.erase(players.end());
        } else {
            players.erase(players.begin() + --indexToRemove);
        }
    }

    cout << players[0] << endl;

}

int main(int argc, char** argv) {
    ifstream input{argv[1]};
    string line;
    while (getline(input, line)) {
        run_challenge(line);
    }
}
