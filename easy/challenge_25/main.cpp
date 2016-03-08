// Challenge 25: 
// Easy: Print all odd numbers from 1 to 100
#include <iostream>

int main(int argc, char** argv) {
  for (int i = 1 ; i < 100 ; i++) {
    if (i % 2 != 0) {
      std::cout << i << std::endl;
    }
  }
}
