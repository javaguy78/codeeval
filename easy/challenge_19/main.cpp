// Challenge 19:
// Easy: Bit Positions
#include <iostream>
#include <fstream>
using namespace std;

int getBit(int val, int bit) {
  return (val & (1 << bit)) >> bit;
}

bool bitPositions(int input, int pos1, int pos2) {
  return getBit(input, pos1 - 1) == getBit(input, pos2 - 1);
}

int main(int argc, char ** argv) {
  std::ifstream inFile {argv[1]};
  int digit;
  while (inFile >> digit){
    int bitPosition1, bitPosition2;
    char input;
    inFile.get(input); // eat a comma
    inFile >> bitPosition1;
    inFile.get(input); // eat a comma
    inFile >> bitPosition2;
    if (bitPositions(digit, bitPosition1, bitPosition2)) {
      std::cout << "true" << std::endl;
    } else {
      std::cout << "false" << std::endl;
    }
  }
  return 0;
}
