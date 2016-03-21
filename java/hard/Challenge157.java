package code.eval.hard.challenge_157;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

// Challenge 157: The Labyrinth
public class Main {

    static String originalMaze = "";
    static File inputFile;
    static int width;

    public static void main(String[] args) {
        getInputFile(args[0]);
        readMaze();
        MazeSolver solver = new MazeSolver(originalMaze, width);
        String solved = solver.solve();
        printMaze(solved);
    }

    private static void getInputFile(String fileName) {
        inputFile = new File(fileName);

        if (!inputFile.exists()) {
            System.err.println("Please specify a valid file name");
            System.exit(1);
        }
    }

    private static void readMaze() {
        try {
            BufferedReader in = new BufferedReader(new FileReader(inputFile));
            String mazeLine;
            mazeLine = in.readLine();
            width = mazeLine.length();
            do {
                originalMaze += mazeLine;
            } while ((mazeLine = in.readLine()) != null);

        } catch (IOException e) {
            System.err.println("Error reading from file...");
            System.exit(1);
        }
    }

    private static void printMaze(String maze) {
        int index = 0;
        do {
            System.out.println(maze.substring(index, index + width));
            index += width;
        } while (index < maze.length());
    }
}

class MazeSolver {

    final String ORIGINAL_MAZE;
    int height, width, start, end;
    LinkedList<Integer> path = new LinkedList<>();
    CellInfo[] cells;

    public MazeSolver(String originalMaze, int width) {
        this.ORIGINAL_MAZE = originalMaze;
        this.width = width;
        height = ORIGINAL_MAZE.length() / width;
        start  = ORIGINAL_MAZE.indexOf(" ");
        end    = ORIGINAL_MAZE.lastIndexOf(" ");
    }

    public String solve() {
        solve(ORIGINAL_MAZE);
        return writeAnswer();
    }

    private void solve(String workingMaze) {
        cells = new CellInfo[workingMaze.length()];
        CellInfo startCell = new CellInfo(0, start);
        cells[start] = startCell;
        path.push(start);
        while (!path.isEmpty()) {
            int coordinate = path.getFirst();
            path.pop();
            runMoves(workingMaze, coordinate);
        }
    }

    private void runMoves(String maze, int coordinate) {
        int column = coordinate % width;
        int row = coordinate / width;
        if (column > 0) {
            update(maze, coordinate - 1, coordinate);
        }
        if (column < (width - 1)) {
            update(maze, coordinate + 1, coordinate);
        }
        if (row > 0) {
            update(maze, coordinate - width, coordinate);
        }
        if (row < (height - 1)) {
            update(maze, coordinate + width, coordinate);
        }
    }

    private void update(String maze, int i, int coordinate) {
        switch (maze.charAt(i)) {
            case '*':
                break;

            case ' ': {
                CellInfo current = cells[coordinate];
                CellInfo newCell = cells[i];
                if (newCell == null || current.getScore() < newCell.getScore()) {
                    newCell = new CellInfo(current.getScore() + 1, coordinate);
                    cells[i] = newCell;
                    path.push(i);
                }
            }
            break;
        }
    }

    private String writeAnswer() {
        String maze = ORIGINAL_MAZE;
        int pathStep = end;
        while (pathStep != start) {
            maze = maze.substring(0, pathStep) + "+" + maze.substring(pathStep + 1);
            CellInfo step = cells[pathStep];
            pathStep = step.getCoordinate();
        }
        maze = maze.substring(0, start) + "+" + maze.substring(start + 1);
        return maze;
    }
}

class CellInfo {
    private int score;
    private int coordinate;

    public CellInfo(int score, int coordinate) {
        this.score = score;
        this.coordinate = coordinate;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(int coordinate) {
        this.coordinate = coordinate;
    }
}

