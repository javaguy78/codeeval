// Created by cschalk on 3/30/16.
// Challenge 157 : The Labyrinth
#include <iostream>
#include <sstream>
#include <fstream>
#include <vector>
#include <queue>
#include <limits>

struct CellInfo {
    int score = std::numeric_limits<int>::max();
    int next;
};

struct Maze {
    std::string maze;
    unsigned int start;
    unsigned int end;
    unsigned int width;
};

std::vector<CellInfo> solve(Maze maze);
void divine(Maze const &maze, std::vector<CellInfo> &path, std::queue<int> &steps, int currentStep);
void update(Maze const &maze, std::vector<CellInfo> &path, std::queue<int> &steps, int currentStep, int nextStep);

std::vector<CellInfo> solve(Maze maze) {
    std::vector<CellInfo> path(maze.maze.length());
    std::queue<int> steps;
    steps.push(maze.start);

    CellInfo start;
    start.score = 0;
    path[maze.start] = start;

    while (!steps.empty()) {
        int step = steps.front();
        steps.pop();
        divine(maze, path, steps, step);
    }

    return path;
}

void divine(Maze const &maze, std::vector<CellInfo> &path, std::queue<int> &steps, int currentStep) {
    update(maze, path, steps, currentStep, currentStep + 1);
    update(maze, path, steps, currentStep, currentStep - 1);
    update(maze, path, steps, currentStep, currentStep + maze.width);
    update(maze, path, steps, currentStep, currentStep - maze.width);
}

void update(Maze const &maze, std::vector<CellInfo> &path, std::queue<int> &steps, int currentStep, int nextStep) {
    if (nextStep > 0 && nextStep < maze.maze.length()) {
        char space = maze.maze.at(nextStep);
        if (space == ' ') {
            CellInfo current = path[currentStep];
            CellInfo newCell = path[nextStep];
            if (current.score < newCell.score) {
                newCell.score = current.score + 1;
                newCell.next = currentStep;
                path[nextStep] = newCell;
                steps.push(nextStep);
            }
        }
    }
}

Maze readMaze(std::ifstream &input) {
    Maze toReturn;
    std::string line;

    std::getline(input, line);
    toReturn.width = line.length();
    toReturn.maze = line;
    int height = 1;

    while (std::getline(input, line)) {
        toReturn.maze += line;
        ++height;
    }

    toReturn.start = toReturn.maze.find_first_of(' ');
    toReturn.end = toReturn.maze.find_last_of(' ');

    return toReturn;
}

void printMaze(Maze &maze, std::vector<CellInfo> &path) {
    int step = maze.end;
    while (step != maze.start) {
        maze.maze.replace(step, 1, "+");
        CellInfo cell = path[step];
        step = cell.next;
    }

    maze.maze.replace(maze.start, 1, "+");
    int offset = 0;
    while ((offset + maze.width) <= (maze.maze.length())) {
        std::cout << maze.maze.substr(offset, maze.width) << std::endl;
        offset = offset + maze.width;
    }
}

int main(int argc, char ** argv) {
    std::ifstream input{argv[1]};
    Maze maze = readMaze(input);
    std::vector<CellInfo> path = solve(maze);
    printMaze(maze, path);
    return 0;
}
