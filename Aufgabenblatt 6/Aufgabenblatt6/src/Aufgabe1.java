/*
    Aufgabe 1) Zweidimensionale Arrays und Gameplay - Sokoban
*/


import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Arrays;

public class Aufgabe1 {
    private static final int SQUARE_SIZE = 40;

    public static void main(String[] args) {
        int[][] test = new int[][] {{1, 2, 3, 4}, {3, 4, 5, 6}, {7, 8, 9, 10}};
        fill(test);
        printFiller(test);


        String[] allLevels = readLevels();
        int levelId = 0;
        int[][] goals = new int[numberOfGoals(allLevels[levelId])][];
        char[][] level = newLevel(goals, allLevels[levelId]);
        boolean gameRunning = true;
        int moveDirection = 0;
        int stepsLevel = 0;
        int stepsTotal = 0;

        setWindowSize(level.length, level[0].length);
        StdDraw.setPenRadius(0.01);
        StdDraw.enableDoubleBuffering();

        drawGame(level, goals);

        while (gameRunning) {
            // up -> right up
            // down -> left down
            // left -> left up
            // right -> right down
            // restart -> r
            // to next level -> t
            if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) {
                moveDirection = 1;
            } else if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) {
                moveDirection = 2;
            } else if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) {
                moveDirection = 3;
            } else if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {
                moveDirection = 4;
            } else if (StdDraw.isKeyPressed(KeyEvent.VK_R)) {
                stepsLevel = 0;
                goals = new int[numberOfGoals(allLevels[levelId])][];
                level = newLevel(goals, allLevels[levelId]);
                drawGame(level, goals);
                StdDraw.pause(200);
            } else if (StdDraw.isKeyPressed(KeyEvent.VK_T)) {
                if (levelId < allLevels.length - 1) { // skip to next level
                    stepsLevel = 0;
                    levelId++;
                    goals = new int[numberOfGoals(allLevels[levelId])][];
                    level = newLevel(goals, allLevels[levelId]);
                    setWindowSize(level.length, level[0].length);
                    drawGame(level, goals);
                    StdDraw.pause(200);
                } else { // end game
                    gameRunning = false;
                    showText(level[0].length * SQUARE_SIZE / 2.0, level.length * SQUARE_SIZE / 2.0, "YOU WON!!! Total steps: " + stepsTotal);
                }
            }

            if (moveDirection != 0) {
                if (move(level, moveDirection)) {
                    stepsLevel++;
                }
                moveDirection = 0;
                drawGame(level, goals);
                if (won(level, goals)) {
                    showText(level[0].length * SQUARE_SIZE / 2.0, level.length * SQUARE_SIZE / 2.0, "Steps: " + stepsLevel);
                    StdDraw.pause(2000);
                    stepsTotal += stepsLevel;
                    stepsLevel = 0;
                    if (levelId < allLevels.length - 1) { // load next level
                        levelId++;
                        goals = new int[numberOfGoals(allLevels[levelId])][];
                        level = newLevel(goals, allLevels[levelId]);
                        setWindowSize(level.length, level[0].length);
                        drawGame(level, goals);
                    } else { // end game
                        gameRunning = false;
                        showText(level[0].length * SQUARE_SIZE / 2.0, level.length * SQUARE_SIZE / 2.0, "YOU WON!!! Total steps: " + stepsTotal);
                    }
                }
                StdDraw.pause(200);
            }
        }
    }

    // reads levels from file / first line is number of levels
    private static String[] readLevels() {
        In reader = new In("sokoban_level.csv");
        int numberOfLevels = reader.readInt();
        int counter = -1; // starts at -1 because first line is empty after reading int
        String[] levels = new String[numberOfLevels];
        while (!reader.isEmpty()) {
            String line = reader.readLine();
            if (line.isEmpty()) {
                counter++;
                levels[counter] = "";
            } else {
                levels[counter] += line + "\n";
            }
        }
        return levels;
    }

    // returns level as char array and fills goal positions into goals array
    private static char[][] newLevel(int[][] goals, String levelString) {
        // calculate array size
        int xSize = 0;
        int ySize = 0;
        int counter = 0;

        for (int i = 0; i < levelString.length(); i++) {
            if (levelString.charAt(i) == '\n') {
                ySize++;
                if (counter > xSize) {
                    xSize = counter;
                }
                counter = 0;
            } else {
                counter++;
            }
        }

        // fill array and goals
        char[][] levelArr = new char[ySize][xSize];
        int goalCounter = 0;
        int x = 0;
        int y = 0;

        for (int i = 0; i < levelString.length(); i++) {
            char item = levelString.charAt(i);
            switch (item) {
                case '.':
                    levelArr[y][x] = ' ';
                    goals[goalCounter] = new int[]{x, y};
                    goalCounter++;
                    x++;
                    break;
                case '\n':
                    y++;
                    x = 0;
                    break;
                case '#':
                case '$':
                case '@':
                case ' ':
                    levelArr[y][x] = item;
                    x++;
                    break;
                default:
                    break;
            }
        }
        return levelArr;
    }

    // returns the total number of goals in the level
    private static int numberOfGoals(String levelString) {
        int goalAmount = 0;
        for (char character: levelString.toCharArray()) goalAmount += character == '.' ? 1 : 0;
        return goalAmount;
    }

    // calculates based on the current position and the direction the new position coordinates
    private static int[] adjacentPosition(int[] position, int direction) {
        switch (direction) {
            case 1:
                return new int[]{position[0], position[1] - 1};
            case 2:
                return new int[]{position[0], position[1] + 1};
            case 3:
                return new int[]{position[0] - 1, position[1]};
            case 4:
                return new int[]{position[0] + 1, position[1]};
        }
        return new int[]{-1, -1};
    }

    // returns position of the figure. [0] = x, [1] = y
    private static int[] figurePosition(char[][] level) {
        int x, y;
        for (y = 0; y < level.length; y++)
            for (x = 0; x < level[y].length; x++)
                if (level[y][x] == '@') return new int[] {x, y};
        return new int[] {-1, -1};
    }

    // moves figure and box if they don't hit an obstacle
    // returns true if figure was moved
    private static boolean move(char[][] level, int direction) {
        int[] currentPosition = figurePosition(level);
        int[] goalPosition = adjacentPosition(currentPosition, direction);
        switch(level[goalPosition[1]][goalPosition[0]]) {
            case ' ':
                level[currentPosition[1]][currentPosition[0]] = ' ';
                level[goalPosition[1]][goalPosition[0]] = '@';
                break;
            case '#':
                return false;
            case '$':
                int[] objectPosition = adjacentPosition(goalPosition, direction);
                char objectAtPosition = level[objectPosition[1]][objectPosition[0]];
                if(objectAtPosition == '#' || objectAtPosition == '$') return false;
                level[currentPosition[1]][currentPosition[0]] = ' ';
                level[goalPosition[1]][goalPosition[0]] = '@';
                level[objectPosition[1]][objectPosition[0]] = '$';
                break;
        }
        return true;
    }

    // returns current position of all boxes
    private static int[][] boxPositions(char[][] level, int numberOfBoxes) {
        int[][] chestKoordinates = new int[numberOfBoxes][2];
        int i = 0;
        for (int y= 0; y < level.length; y++) {
            for (int x = 0; x < level[y].length; x++) {
                if (level[y][x] == '$') {
                    chestKoordinates[i][0] = x;
                    chestKoordinates[i][1] = y;
                    i++;
                }
            }
        }
        return chestKoordinates;
    }

    // returns true if all boxes are on a goal
    private static boolean won(char[][] level, int[][] goals) {
        int[][] chestKoordinates = boxPositions(level, goals.length);
        int[][] goalsBuffer = goals.clone();
        boolean chestFound;
        for (int i = 0; i < chestKoordinates.length; i++) {
            chestFound = false;
            for (int j = 0; j < goalsBuffer.length; j++) {
                if (
                        chestKoordinates[i][0] == goalsBuffer[j][0] &&
                                chestKoordinates[i][1] == goalsBuffer[i][1]
                ) chestFound = true;    // Assuming there can't be two chests ontop of each other
            }
            if (!chestFound) return false;
        }
        return true;
    }

    // helping method to set the StdDraw window size and the scaling of the axis
    private static void setWindowSize(int ySquares, int xSquares) {
        StdDraw.setCanvasSize(SQUARE_SIZE * xSquares, SQUARE_SIZE * ySquares);
        StdDraw.setXscale(0, SQUARE_SIZE * xSquares);
        StdDraw.setYscale(0, SQUARE_SIZE * ySquares);
    }

    // helping method for writing text in the StdDraw window
    private static void showText(double x, double y, String text) {
        StdDraw.clear(Color.white);
        StdDraw.setPenColor(Color.black);
        StdDraw.text(x, y, text);
        StdDraw.show();
    }

    // draws the current level with all elements
    private static void drawGame(char[][] level, int[][] goals) {
        StdDraw.clear();
        StdDraw.setPenColor(Color.white);
        for (int y = 0; y < level.length; y++) {
            for (int x = 0; x < level[y].length; x++) {
                double x_val = x*SQUARE_SIZE + SQUARE_SIZE/2.0;
                double y_val = (level.length - y - 1)*SQUARE_SIZE + SQUARE_SIZE/2.0;
                if (level[y][x] == '#') StdDraw.picture(x_val, y_val, "./wall.png", SQUARE_SIZE, SQUARE_SIZE); // Is wall
                else if (level[y][x] == '$') StdDraw.picture(x_val, y_val, "./box.png", SQUARE_SIZE, SQUARE_SIZE); // Is chest
                else if (level[y][x] == '@') StdDraw.picture(x_val, y_val, "./figure.png", SQUARE_SIZE, SQUARE_SIZE); // Is player
                else if (containsElement(goals, new int[] {x, y})) StdDraw.picture(x_val, y_val, "./endpoint.png", SQUARE_SIZE, SQUARE_SIZE); // Is Endpoint
                else if (level[y][x] == ' ') StdDraw.filledSquare(x_val, y_val, SQUARE_SIZE/2.00); // Is empty
            }
        }
        StdDraw.show();
    }

    private static boolean containsElement(int[][] SuperSet, int[] SubSet) {
        for (int[] part: SuperSet) if (Arrays.equals(part, SubSet)) return true;
        return false;
    }

    private static void fill(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                input[i][j] = i + j + 1;
            }
        }
    }

    private static void printFiller(int[][] filler) {
        int currVal = 1;
        for (int i = 0; i < filler.length; i++) {
            for (int j = 0; j < filler[i].length; j++) {
                System.out.print(filler[i][j]);
                System.out.print(", ");
            }
            System.out.println("");
        }
    }
}
