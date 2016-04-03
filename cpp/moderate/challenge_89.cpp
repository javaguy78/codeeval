// Created by cschalk on 4/2/16.
// Challenge 89 : Pass Triangle
#include <iostream>
#include <fstream>
#include <stack>
#include <vector>
#include <sstream>

using namespace std;

vector<int> eval(vector<int> top, vector<int> bottom) {
    for (int i = 0; i < top.size(); i++) {
        int left = top[i] + bottom[i];
        int right = top[i] + bottom[i + 1];
        top[i] = max(left, right);
    }
    return top;
}

void runChallenge(stack<vector<int>> triangle) {
    vector<int> bottom = triangle.top();
    triangle.pop();
    do {
        bottom = eval(triangle.top(), bottom);
        triangle.pop();
    } while (!triangle.empty());

    cout << bottom[0] << endl;
}

int main(int argc, char ** argv) {
    ifstream input {argv[1]};
    stack<vector<int>> triangle;
    string line;
    while (getline(input, line)) {
        vector<int> row;
        stringstream ls(line);
        int cell;
        while (ls >> cell) {
            row.push_back(cell);
        }
        triangle.push(row);
    }

    runChallenge(triangle);



    return 0;
}

