// Created by cschalk on 3/28/16.
// Challenge 239 : Quick as a flash
#include <iostream>
#include <fstream>
#include <vector>
#include <sstream>

using namespace std;

int pivots;

void quickSort(int arr[], int left, int right) {
    int i = left, j = right;
    int tmp;
    int pivot = arr[(left + right) / 2];
    pivots++;

    /* partition */
    while (i <= j) {
        while (arr[i] < pivot)
            i++;
        while (arr[j] > pivot)
            j--;
        if (i <= j) {
            tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    };

    /* recursion */
    if (left < j)  quickSort(arr, left, j);
    if (i < right) quickSort(arr, i, right);
}

int main(int argc, char ** argv) {
    ifstream input {argv[1]};
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

