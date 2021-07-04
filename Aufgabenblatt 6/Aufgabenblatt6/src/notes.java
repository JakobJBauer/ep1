import java.util.Arrays;

public class notes {

    static int[][] reshape(int[][] inputArray){
        if (inputArray == null) {
            return new int[][]{};
        }
        int cnt = 0;
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                cnt++;
            }
        }
        int[][] result;
        if (cnt % 2 == 0) {
            // Gerade Anzahl an Elementen
            // Anzahl an Zeilen = cnt / 2
            result = new int[cnt / 2][2];
        } else {
            result = new int[cnt / 2 + 1][2];
        }
        int row = 0;
        int col = 0;
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                if (row % 2 == 0) {
                    result[row][col] = inputArray[i][j];
                } else {
                    result[row][1-col] = inputArray[i][j];
                }
                col++;
                if (col > 1) {
                    col = 0;
                    row++;
                }
            }
        }
        // Überschüssiger Eintrag ist per Default 0
        return result;
    }

    static void mask(int[][] inputArray) {
        if (inputArray == null) {
            return;
        }
        // Last row should not be considered to be changed
        for (int i = 0; i < inputArray.length - 1; i++) {
            if(inputArray[i] != null && inputArray[i+1] != null && inputArray[i].length == inputArray[i+1].length) {
                boolean arraysAreEqual = true;
                for (int j = 0; j < inputArray[i].length; j++) {
                    if (inputArray[i][j] != inputArray[i+1][j]) {
                        arraysAreEqual = false;
                        break;
                    }
                }
                if (arraysAreEqual) {
                    for (int j = 0; j < inputArray[i].length; j++) {
                        inputArray[i][j] = -1;
                    }
                }
            }
        }
    }

    static int getMaxOppositeSum(int[] sequence, int start, int end) {
        return (start < end) ?
                Math.max(getMaxOppositeSum(sequence, start + 1, end - 1), sequence[start] + sequence[end]) : 0;
    }

    public static void main(String[] args) {
        int[][] test1 = {{5, 2, 4}, {2, 7, 3}, {9, 5, 8}};
        int[][] test2 = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
        int[][] test3 = {{6}, {6, 7}, {6, 7}, {6, 7}, {7, 6}};
        int[] seq1 = {1, 2, 4, 4, 5, 5, 5, 10};

        int[][] result1 = reshape(test1);
        int[][] result2 = reshape(test3);
        System.out.println(Arrays.deepToString(result1));
        System.out.println(Arrays.deepToString(result2));
        System.out.println(Arrays.deepToString(reshape(new int[][]{{}})));

        mask(test1);
        mask(test2);
        mask(test3);
        System.out.println(Arrays.deepToString(test1));
        System.out.println(Arrays.deepToString(test2));
        System.out.println(Arrays.deepToString(test3));

        System.out.println(getMaxOppositeSum(seq1, 0, 7));
        System.out.println(getMaxOppositeSum(seq1, 0, 5));
        System.out.println(getMaxOppositeSum(seq1, 4, 7));
    }

}