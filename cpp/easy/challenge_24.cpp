// Created by cschalk on 4/11/16.
// Challenge 24: Sum of numbers in a file
#include <iostream>
#include <fstream>
using namespace std;

int main (int argc, char ** argv) {
    ifstream input {argv[1]};
    int number;
    int sum = 0;
    while (input >> number) {
        sum += number;
    }
    cout << sum << endl;
}

