// Challenge 4: 
// Easy: Sum of first 1000 primes
#include <iostream>
#include <math.h>

int sum = 0;
int primes = 0;

bool isPrime(int test) {
  if (test <= 1) return false;
  if (test == 2) return true;
  for (int i = 2; i < sqrt (test) + 1 ; i++) {
    if (test % i == 0) return false;
  }
  return true;
}

int main(int argc, char ** argv) {
    int number = 1;
    do {
      if (isPrime(number)) {
	sum += number;
	primes++;
      }
      number++;
    } while (primes < 1000);
    
    std::cout << sum;
    return 0;
}