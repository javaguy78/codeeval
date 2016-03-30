// Created by cschalk on 3/28/16.
// Challenge 239 : Quick as a flash
#include <iostream>
#include <fstream>
#include <vector>
#include <sstream>

using namespace std;

int pivots;

int partition(int * arr, int left, int right) {
    int pivotValue = arr[left];
    int i = left;
    int j = right;
    for ( ; ; ) {
        while (arr[j] > pivotValue) j--;
        while (arr[i] < pivotValue) i++;
        if (i < j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        } else
            return j;
    }
}

void quickSort(int * arr, int left, int right) {
    int index = partition(arr, left, right);
    pivots++;
    if (left < index - 1)
        quickSort(arr, left, index - 1);
    if (index + 1 < right)
        quickSort(arr, index + 1, right);
}

int main(int argc, char ** argv) {
    ifstream input{argv[1]};
    string line;

    while (getline(input, line)) {
        stringstream ss(line);
        vector<int> ints;
        int in;
        while (ss >> in) {
            ints.push_back(in);
        }

        if (ints.size() > 0) {
            pivots = 0;
            quickSort(ints.data(), 0, ints.size() - 1);
            cout << pivots << endl;
        }
    }

    return 0;
}

