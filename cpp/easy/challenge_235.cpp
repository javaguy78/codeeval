// Created by cschalk on 4/14/16.
// Challenge 235 : Simple or trump
#include <iostream>
#include <fstream>
#include <sstream>
using namespace std;

namespace {
    struct Card {
        int value;
        char suit;
    public:
        Card(string const &);

    private:
        void decode(string const &);
    };

    Card::Card(string const &card) {
        suit = card.at(card.length() - 1);
        Card::decode(card.substr(0, card.length() - 1));
    };

    void Card::decode(const string &strVal) {
        if (strVal.compare("A") == 0) {
            value = 14;
        } else if (strVal.compare("K") == 0) {
            value = 13;
        } else if (strVal.compare("Q") == 0) {
            value = 12;
        } else if (strVal.compare("J") == 0) {
            value = 11;
        } else {
            value = stoi(strVal);
        }
    };
}

string max(string const &in1, string const &in2, char trump) {
    Card card1 (in1);
    Card card2 (in2);
    if (card1.suit == trump && card2.suit == trump) {
        return (card1.value > card2.value) ? in1 : in2;
    } else if (card1.suit == trump) {
        return in1;
    } else if (card2.suit == trump) {
        return in2;
    } else {
        if (card1.value == card2.value) {
            return in1 + " " + in2;
        } else {
            return (card1.value > card2.value) ? in1 : in2;
        }
    }
}

void runChallenge(string const &line) {
    string card1, card2;
    char trump, delimiter;
    stringstream ss(line);
    ss >> card1 >> card2 >> delimiter >> trump;

    cout << max(card1, card2, trump) << endl;
}

int main(int argc, char ** argv) {
    ifstream input {argv[1]};
    string line;
    while (getline(input, line)) {
        runChallenge(line);
    }
}

