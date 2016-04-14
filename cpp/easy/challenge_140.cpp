// Created by cschalk on 4/11/16.
// Challenge 140 : Data Recovery
#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>
using namespace std;

template <typename T>
vector<T> parse_out(string const &in) {
    vector<T> toReturn;
    stringstream ss(in);
    T element;
    while (ss >> element) {
        toReturn.push_back(element);
    }
    return toReturn;
}

void print_original_message(vector<string> &words, vector<int> &hints) {
    vector<string> original (words.size());
    fill(original.begin(), original.end(), "");

    // shuffle what we know
    for (int i = 0 ; i < hints.size() ; ++i) {
        original[hints[i] - 1] = words[i];
        words[i] = "";
    }

    // fill in what we don't know
    for (string word : words) {
        if (word.compare("") != 0) {
            for (int i = 0 ; i < original.size() ; ++i) {
                if (original[i].compare("") == 0) {
                    original[i] = word;
                    break;
                }
            }
        }
    }

    for (string word : original) {
        cout << word << " ";
    }

    cout << endl;
}

void runChallenge(string &line) {
    unsigned long index = line.find_first_of(";");
    string wordString = line.substr(0, index);
    string hintString = line.substr(index + 1, string::npos);
    vector<string> words = parse_out<string>(wordString);
    vector<int> hints = parse_out<int>(hintString);
    print_original_message(words, hints);
}

int main(int argc, char ** argv) {
    ifstream input {argv[1]};
    string line;
    while (getline(input, line)) {
        runChallenge(line);
    }
}
