// Created by cschalk on 5/31/16.
// Challenge 23 - Beautiful Strings
#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> getCharFrequency(const string line) {
    string upper = line;
    transform(upper.begin(), upper.end(), upper.begin(), ::toupper);
    vector<int> freq (26);
    fill(freq.begin(), freq.end(), 0);
    for (char c : upper) {
        if (isalpha(c)) {
            int charIndex = c - 65;
            ++freq[charIndex];
        }
    }
    return freq;
}

void run_challenge(const string line) {
    vector<int> freq = getCharFrequency(line);
    sort(freq.begin(), freq.end(), ::greater<int>());
    int totalBeauty = 0;
    int maxBeauty = 26;
    for (int i : freq) {
        totalBeauty += (i * maxBeauty--);
    }
    cout << totalBeauty << endl;
}

int main(int argc, char ** argv) {
    ifstream input {argv[1]};
    string line;
    while (getline(input, line)) {
        run_challenge(line);
    }
}

