// Created by cschalk on 9/19/2016.
// Challenge 161: Conway's Game of Life
#include <iostream>
#include <fstream>
#include <sstream>
#include <algorithm>

using namespace std;
std::vector<string> stage;
int height;

void readInitialState(char* &inFile) {
    std::ifstream in {inFile};
    std::string line;

    // get first line
    std::getline(in, line);
    stage.push_back(line);
    height = 1;

    // get rest of lines
    while (std::getline(in, line)) {
        stage.push_back(line);
        ++height;
    }
}

bool isAlive(int position, const string &line) {
    if (position >= 0 && position < line.length()) {
        return line.at(position) == '*';
    } else {
        return false; // out of bounds are dead
    }
}

int getLivingNeighbors(int char_pos, int row) {
    int neighbors = 0;
    string str_row;

    // neighbors on previous line
    if (row > 0) {
        str_row = stage[row - 1];
        if (isAlive(char_pos - 1, str_row)) { ++neighbors; }
        if (isAlive(char_pos    , str_row)) { ++neighbors; }
        if (isAlive(char_pos + 1, str_row)) { ++neighbors; }
    }

    // neighbors on current line
    str_row = stage[row];
    if (isAlive(char_pos - 1, str_row)) { ++neighbors; }
    if (isAlive(char_pos + 1 , str_row)) { ++neighbors; }

    // neighbors on next row
    if (row < height - 1) {
        str_row = stage[row + 1];
        if (isAlive(char_pos - 1, str_row)) { ++neighbors; }
        if (isAlive(char_pos    , str_row)) { ++neighbors; }
        if (isAlive(char_pos + 1, str_row)) { ++neighbors; }
    }

    return neighbors;
}

string eval(const string &line, int row) {
    string next = "";
    for (int pos = 0 ; pos < line.length() ; ++pos) {
        char current = line.at(pos);
        bool alive = isAlive(pos, line);
        int neighbors = getLivingNeighbors(pos, row);

        if (!alive && neighbors == 3) {
            next += "*"; // becomes alive
        } else {
            if (neighbors < 2 || neighbors > 3) {
                next += "."; // dies
            } else {
                next += current; // keeps value
            }
        }
    }
    return next;
}

void tick() {
    vector<string> next;
    for (int i = 0; i < height ; ++i) {
        string line = stage[i];
        string nextLine = eval(line, i);
        next.push_back(nextLine);
    }

    stage.clear();
    for (int i = 0; i < height ; ++i) {
        stage.push_back(next[i]);
    }
}

void playGame() {
    // Only play game for 10 ticks
    for (int i = 0 ; i < 10 ; ++i) {
        tick();
    }
}

void printEndResult() {
    for (int i = 0; i < height ; i++) {
        string out = stage[i];
        std::cout << out << std::endl;
    }
}

int main(int argc, char** argv) {
    readInitialState(argv[1]);
    playGame();
    printEndResult();
}

