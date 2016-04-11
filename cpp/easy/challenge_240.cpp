// Created by cschalk on 4/11/16.
// Challenge 240: Mersenne numbers less than x
#include <iostream>
#include <fstream>
#include <vector>
using namespace std;

// Be careful, the challenge asks for Mersenne Numbers, not Mersenne primes.
vector<int> primes = {3, 7, 31, 127, 2047};

int main(int argc, char ** argv) {
    ifstream input {argv[1]};
    int test;
    while (input >> test) {
        bool out = false;
        for (int prime : primes) {
            if (prime < test) {
                if (out) {
                    cout << ", ";
                }
                cout << prime;
                out = true;
            }
        }
        cout << endl;
    }
}

