// Challenge 22:
// Print the nth digit of the Fibonacci sequence
#include <iostream>
#include <fstream>
#include <string>
using namespace std;

void printNthFibDigit(int digit) {
  if (digit == 0) cout << 0 << endl;
  else if (digit == 1) cout << 1 << endl;
  else if (digit == 2) cout << 1 << endl;
  else {
    int a1 = 1, a2 = 1, tmp = 0;
    for (int i = 3 ; i < digit ; i++) {
      tmp = a1 + a2;
      a1 = a2;
      a2 = tmp;    
    }
    cout << a1 + a2 << endl;
  }  
} 

int main(int argc, char **argv) {
  std::ifstream inFile {argv[1]};
  int digit;
  while (inFile >> digit) {
    printNthFibDigit(digit);
  }
  return 0;
}
