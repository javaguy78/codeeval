// Created by cschalk on 4/6/16.
// Challenge 52 : Text Dollars
#include <iostream>
#include <fstream>

using namespace std;

string decodeTriplet(const string &, int);
string decodeSingle(const char);
string decodeTeens(const char);
string decodeTens(const char);
string decodeNumber(const char, bool, bool, bool);

int main(int argc, char ** argv) {
    ifstream input {argv[1]};
    string number;
    while (getline(input, number)) {
        if (number.compare("") != 0) {
            number = "0000000000" + number; // pad the number
            string textDollars;
            for (int i = 3; i < 10; i += 3) {
                string toDecode = number.substr(number.length() - i, 3);
                if (toDecode.compare("000") != 0) {
                    string triplet = decodeTriplet(toDecode, i);
                    textDollars = triplet + textDollars;
                }
            }

            cout << textDollars << "Dollars" << endl;
        }
    }
}

string decodeTriplet(const string &triplet, int count) {
    string toReturn = "";
    if (triplet.at(0) != '0') {
        toReturn = decodeSingle(triplet.at(0)) + "Hundred";
    }

    if (triplet.at(1) == '1') {
        toReturn += decodeTeens(triplet.at(2));
    } else {
        toReturn += decodeTens(triplet.at(1));
        toReturn += decodeSingle(triplet.at(2));
    }

    switch(count / 3) {
        case 2 : toReturn += "Thousand"; break;
        case 3 : toReturn += "Million" ; break;
    }

    return toReturn;
}

string decodeSingle(const char in) {
    return decodeNumber(in, false, false, true);
}

string decodeTeens(const char in) {
    return decodeNumber(in, false, true, false);
}

string decodeTens(const char in) {
    return decodeNumber(in, true, false, false);
}

string decodeNumber(const char in, bool tens, bool teens, bool single) {
    switch (in) {
        case '0' : if (teens) return "Ten"; break;
        case '1' : {
            if (teens) return "Eleven";
            if (single) return "One";
            break;
        }
        case '2' : {
            if (tens) return "Twenty";
            if (teens) return "Twelve";
            if (single) return "Two";
            break;
        }
        case '3' : {
            if (tens) return "Thirty";
            if (teens) return "Thirteen";
            if (single) return "Three";
            break;
        }
        case '4' : {
            if (tens) return "Forty";
            if (teens) return "Fourteen";
            if (single) return "Four";
            break;
        }
        case '5' : {
            if (tens) return "Fifty";
            if (teens) return "Fifteen";
            if (single) return "Five";
            break;
        }
        case '6' : {
            if (tens) return "Sixty";
            if (teens) return "Sixteen";
            if (single) return "Six";
            break;
        }
        case '7' : {
            if (tens) return "Seventy";
            if (teens) return "Seventeen";
            if (single) return "Seven";
            break;
        }
        case '8' : {
            if (tens) return "Eighty";
            if (teens) return "Eighteen";
            if (single) return "Eight";
            break;
        }
        case '9' : {
            if (tens) return "Ninety";
            if (teens) return "Nineteen";
            if (single) return "Nine";
            break;
        }
    }
    return "";
}