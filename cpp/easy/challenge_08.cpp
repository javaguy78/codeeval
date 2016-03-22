// Created by cschalk on 3/21/16.
// challenge 08 : Reverse string word order.
#include <iostream>
#include <fstream>
#include <sstream>
#include <stack>

using namespace std;

int main(int argc, char ** argv) {

    std::ifstream input {argv[1]};
    std::string line;

    while (std::getline(input, line)) {
        std::stack<std::string> reversed;
        std::string word;
        std::stringstream ss(line);
        while (ss >> word) {
            reversed.push(word);
            reversed.push(" ");
        }
        reversed.pop(); // lose the first space;
        while(!reversed.empty()) {
            std::cout << reversed.top();
            reversed.pop();
        }
        std::cout << std::endl;
        flush(std::cout);
    }

    return 0;
}
