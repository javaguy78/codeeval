// Challenge 19:
// Easy: Bit Positions
#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <sstream>
using namespace std;

void bitPositions(int input, int pos1, int pos2) { 
  std::string binary;
  do {
    binary.push_back(0 + (input & 1));
  } while (input >>=1);
  if (binary.at(pos1 - 1) == binary.at(pos2 - 1)) {
    cout << "true" << endl;
  } else {
    cout << "false" << endl;
  }
}

int main(int argc, char ** argv) {
  std::ifstream inFile {argv[1]};
  string line;
  while (std::getline(inFile, line)) {
    std::vector<int> vals;
    std::stringstream ss(line);
    int i;
    while (ss >> i) {
      vals.push_back(i);
      if (ss.peek() == ',') {
	ss.ignore();
      }
    }
    bitPositions(vals.at(0), vals.at(1), vals.at(2));
  }
  return 0;
}
