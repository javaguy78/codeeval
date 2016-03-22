package hard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;

/**
 * Challenge 157 : The Labyrinth
 * Created by cschalk on 3/21/16.
 */
public class Challenge157 {

    private static String originalMaze = "";
    private static int width;

    public static void main(String[] args) throws Exception {
        readMaze(args[0]);
        MazeSolver solver = new MazeSolver(originalMaze, width);
        String solved = solver.solve();
        printMaze(solved);
    }

    private static void readMaze(String fileName) throws Exception {
        File inputFile = new File(fileName);
        BufferedReader in = new BufferedReader(new FileReader(inputFile));
        String mazeLine;
        mazeLine = in.readLine();
        width = mazeLine.length();
        do {
            originalMaze += mazeLine;
        } while ((mazeLine = in.readLine()) != null);
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

    private final String ORIGINAL_MAZE;
    private final int height, width, start, end;
    private final LinkedList<Integer> path = new LinkedList<>();
    private CellInfo[] cells;

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
    private final int score;
    private final int coordinate;

    public CellInfo(int score, int coordinate) {
        this.score = score;
        this.coordinate = coordinate;
    }

    public int getScore() {
        return score;
    }

    public int getCoordinate() {
        return coordinate;
    }

}

