// challenge 08: Reverse string word order.
#include <iostream>
#include <fstream>
#include <sstream>
using namespace std;

int main(int argc, char ** argv) {

    std::fstream input {argv[1]};
    std::string line;

    while (std::getline(input, line)) {
        std::string out;
        std::string word;
        std::stringstream ss(line);
        while (ss >> word) {
            if (out.empty()) {
                out = word;
            } else {
                out = word + " " + out;
            }
        }
        std::cout << out << std::endl;
    }

    return 0;
}
