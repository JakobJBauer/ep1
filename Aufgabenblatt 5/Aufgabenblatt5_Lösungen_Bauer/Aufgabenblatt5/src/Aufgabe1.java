/*
    Aufgabe 1) Zweidimensionale Arrays - Diverse Methoden
*/

import java.util.Arrays;

public class Aufgabe1 {

    private static int[][] genFilledArray(int n) {
        int[][] twoDimensional = new int[n][n];
        for (int i = 0; i < twoDimensional.length; i++) {
            int columnFiller = i;
            boolean countUpwards = true;
            for (int j = 0; j < twoDimensional[i].length; j++) {
                if(i + j == n) countUpwards = false;
                if (countUpwards) columnFiller++; else columnFiller--;
                twoDimensional[i][j] = columnFiller;
            }
        }
        return twoDimensional;
    }

    private static void shiftLinesInArray(int[][] workArray) {
        /*int[] buffer = workArray[workArray.length - 1];
        for (int i = workArray.length - 1; i > 0; i--)
            workArray[i] = workArray[i - 1];
        workArray[0] = buffer;*/                                // Buffer not allowed

        // Use one element of the subarray as an buffer instead, and go through every subarray
        // If you want to swap Input[0] and Input[1] (within for loop of subarray):
        //      Input[0][i] = Input[1][i] + Input [0][i]
        //      Input [1][i] = Input[0][i] - Input[1][i]
        //      Input[0][i] = Input[0][i] - Input[1][i]
        // Example: int[][] Input = {{10}, {20}}. Expected Output: {{20}, {10}}
        // Input[0][0] = 10 + 20 = 30
        // Input[1][0] = 30 - 20 = 10
        // Input[0][0] = 30 - 10 = 20   --> Worked

        // Therefore, always swap the last element with the element before for the whole array
        System.out.println("\n\n\nDude bin DAAAAAAAAAAAAAAAAAAAAAAA");
        printArray(workArray);
        for (int i = workArray.length - 1; i > 0; i--) {
            for (int j = 0; j < workArray[i].length; j++) {
                workArray[i-1][j] = workArray[i][j] + workArray[i-1][j];
                workArray[i][j] = workArray[i-1][j] - workArray[i][j];
                workArray[i-1][j] = workArray[i-1][j] - workArray[i][j];
            }
        }
        System.out.println("\n\n\nJetzt daaaaaaaaaa");
        printArray(workArray);                              // Help me, only works if all subArrays are the same size, which is not the case -.-

        // Last Chance: Swap Adresses by adding and subtracting them like described in the scenario above (does the OS allow this???)
        /*for (int i = workArray.length - 1; i > 0; i++) {
            workArray[i-1] = workArray[i] + workArray[i-1];                 // Nope, does not work
        }*/
    }

    private static int[][] extendArray(int[][] inputArray) {
        int maxlength = 0;
        for (int[] array: inputArray) maxlength = Math.max(array.length, maxlength);
        int[][] outputArray = new int[inputArray.length][maxlength];
        boolean fillLeft = false; // Inverted
        for (int i = 0; i < outputArray.length; i++) {
            fillLeft = !fillLeft;
            int amountOfZeros = outputArray[i].length - inputArray[i].length;
            for (int j = 0; j < outputArray[i].length; j++) {
                if(fillLeft) outputArray[i][j] = j < amountOfZeros ? 0 : inputArray[i][j - amountOfZeros];
                else outputArray[i][j] = j > inputArray[i].length - 1 ? 0 : inputArray[i][j];
            }
        }
        return outputArray;
    }

    private static int[] reformatArray(int[][] inputArray) {
        int[] output = new int[inputArray.length];
        for (int i = 0; i < output.length; i++) {
            output[i] = 0;
            for (int j = 0; j < inputArray[i].length; j++)
                output[i] += Math.pow(2, j) * inputArray[i][inputArray[i].length - j - 1];
        }
        return output;
    }

    //Vorgegebene Methode - BITTE NICHT VERÄNDERN!
    private static void printArray(int[][] inputArray) {
        if (inputArray != null) {
            for (int i = 0; i < inputArray.length; i++) {
                for (int j = 0; j < inputArray[i].length; j++) {
                    System.out.print(inputArray[i][j] + "\t");
                }
                System.out.println();
            }
        }
    }

    //Vorgegebene Methode - BITTE NICHT VERÄNDERN!
    private static void printArray(int[] inputArray) {
        if (inputArray != null) {
            for (int i = 0; i < inputArray.length; i++) {
                System.out.print(inputArray[i] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] array = genFilledArray(2);
        printArray(array);
        assert (Arrays.deepEquals(array, new int[][]{{1, 2}, {2, 1}}));
        System.out.println();

        array = genFilledArray(4);
        printArray(array);
        assert (Arrays.deepEquals(array, new int[][]{{1, 2, 3, 4}, {2, 3, 4, 3}, {3, 4, 3, 2}, {4, 3, 2, 1}}));
        System.out.println();

        array = genFilledArray(7);
        printArray(array);
        System.out.println();


        int[][] array1 = new int[][]{{1, 3, 5}, {6, 2, 1}, {0, 7, 9}};
        shiftLinesInArray(array1);
        assert (Arrays.deepEquals(array1, new int[][]{{0, 7, 9}, {1, 3, 5}, {6, 2, 1}}));
        printArray(array1);
        System.out.println();

        array1 = new int[][]{{1, 5, 6, 7}, {1, 9, 3}, {4}, {6, 3, 0, 6, 2}, {6, 3, 0}};
        shiftLinesInArray(array1);
        assert (Arrays.deepEquals(array1, new int[][]{{6, 3, 0}, {1, 5, 6, 7}, {1, 9, 3}, {4}, {6, 3, 0, 6, 2}}));
        printArray(array1);
        System.out.println();


        int[][] array2 = new int[][]{{4}, {1, 2, 3}, {5, 6}, {7, 8, 9, 1}};
        int[][] array2new1 = extendArray(array2);
        printArray(array2new1);
        assert (Arrays.deepEquals(array2new1, new int[][]{{0, 0, 0, 4}, {1, 2, 3, 0}, {0, 0, 5, 6}, {7, 8, 9, 1}}));
        System.out.println();

        array2 = new int[][]{{1, 0, 1, 1, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 1}, {1, 1}, {1, 0, 0, 0}, {1, 1, 0, 1}, {1}, {1}};
        int[][] array2new2 = extendArray(array2);
        printArray(array2new2);
        assert (Arrays.deepEquals(array2new2, new int[][]{{1, 0, 1, 1, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 1}, {1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 1}, {1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1}}));
        System.out.println();

        array2 = new int[][]{{1, 3, 2}, {5, 1}, {6, 8, 5, 4}, {9, 4, 1, 9, 2}, {1, 8, 7, 5, 3, 2, 5}, {3}};
        int[][] array2new3 = extendArray(array2);
        printArray(array2new3);
        assert (Arrays.deepEquals(array2new3, new int[][]{{0, 0, 0, 0, 1, 3, 2}, {5, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 6, 8, 5, 4}, {9, 4, 1, 9, 2, 0, 0}, {1, 8, 7, 5, 3, 2, 5}, {3, 0, 0, 0, 0, 0, 0}}));
        System.out.println();


        int[][] array3 = new int[][]{{1, 0, 1, 1}, {0, 1, 1}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 0}, {1, 1, 1, 1, 1}};
        int[] array3new = reformatArray(array3);
        printArray(array3new);
        assert (Arrays.equals(array3new, new int[]{11, 3, 24, 2, 2, 31}));
        System.out.println();

        array3 = array2new2.clone();
        array3new = reformatArray(array3);
        printArray(array3new);
        assert (Arrays.equals(array3new, new int[]{176, 124, 3, 128, 13, 128, 1}));
        System.out.println();
    }
}

