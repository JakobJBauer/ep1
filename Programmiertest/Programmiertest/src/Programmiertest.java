import java.util.Arrays;

public class Programmiertest {

    //TODO: Schreiben Sie hier die geforderten Methoden.

    static int[][] removeLeadingZeros(int[][] inputArray){
        int[][] output = new int[inputArray.length][];
        for (int i = 0; i < inputArray.length; i++) {
            int amountOfLeadingZeros = 0;
            for (int j = 0; j < inputArray[i].length; j++) {
                if(inputArray[i][j] == 0) amountOfLeadingZeros++;
                else break;
            }
            output[i] = new int[inputArray[i].length - amountOfLeadingZeros];

            int outIndex = 0;
            boolean foundNotZero = false;
            for (int j = 0; j < inputArray[i].length; j++) {
                if(inputArray[i][j] != 0 || foundNotZero) {
                    foundNotZero = true;
                    output[i][outIndex] = inputArray[i][j];
                    outIndex++;
                }
            }
        }
        return output;
    }

    static void mask(int[][] inputArray, int[] rows, int[] cols){
        for (int row = 0; row < inputArray.length; row++) {
            for (int col = 0; col < inputArray[row].length; col++) {

                // Check row
                boolean isInRows = false;
                for (int j : rows) {
                    if (row == j) {
                        isInRows = true;
                        break;
                    }
                }

                // Check col
                boolean isInCols = false;
                for (int j : cols) {
                    if (col == j) {
                        isInCols = true;
                        break;
                    }
                }

                if (isInCols && isInRows) inputArray[row][col] = 0;
            }
        }
    }

    static String duplicateCharacters(String sequence, String duplicator){
        if (sequence.equals("")) return "";
        if(duplicator.charAt(0) == '1') return "" + sequence.charAt(0) + sequence.charAt(0) + duplicateCharacters(sequence.substring(1), duplicator.substring(1));
        return "" + sequence.charAt(0) + duplicateCharacters(sequence.substring(1), duplicator.substring(1));
    }


    public static void main(String[] args) {
        //TODO: Erweitern Sie "main" laut Angabe.
        int[][] test1 = {{0, 2, 4}, {2, 0, 0}, {0, 0, 1}};
        int[][] test2 = {{1, 2, 3}, {1, 2, 3, 4, 5}, {1, 2, 3}, {1, 2, 3, 4, 5}};
        int[][] test3 = {{2}, {0, 7}, {6, 7, 8}, {6, 0}, {0, 0}};
        String seq1 = "ABA";
        int[][] data0 = {{3, 0}, {0, 1}, {2, 2}};

        System.out.println("removeLeadingZeros(test1) = " + Arrays.deepToString( removeLeadingZeros(test1)) );
        System.out.println("removeLeadingZeros(test3) = " + Arrays.deepToString( removeLeadingZeros(test3)) );
        
        mask(test2, new int[] {1, 2, 3}, new int[] {0, 1, 4});
        System.out.println("mask(test2) = " + Arrays.deepToString( test2 ));
        mask(test3,new int[]{0,2,4},new int[]{0,1});
        System.out.println("mask(test3) = " + Arrays.deepToString( test3 ));
        mask(test1,new int[]{},new int[]{0,1});
        System.out.println("mask(test1) = " + Arrays.deepToString( test1 ));

        //System.out.println("replicateCharacters(seq1, \"010\") = " + replicateCharacters(seq1, "010"));

        //System.out.println("replicateCharacters(\"SAMBA\", \"10001\") = " + replicateCharacters("SAMBA", "10001"));

        // Eigene Testfälle incoming
        // *** DANGER ZONE ***
        // DO NOT ENTER
        System.out.println("\n\nDon't enter!");
        int[][] selfTest = {{0, 2, 4}, {2, 0, 0}, {0, 0, 1}};
        mask(selfTest, new int[] {}, new int[] {});
        System.out.println("mask(no cols or rows) = " + Arrays.deepToString(selfTest));

        System.out.println("Arrays.deepToString(labelPath(3, new int[][] {})) = " + Arrays.deepToString(labelPath(3, new int[][] {})));
        System.out.println("Arrays.deepToString(labelPath(3, new int[][] {})) = " + Arrays.deepToString(labelPath(4, data0)));
    }

    static int[][] labelPath(int n, int[][] points) {
        int[][] output = new int[n][n];

        // Überall mal n einfüllen
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                output[i][j] = n;
            }
        }

        // points durchgehen und alle eingetragenen punkte mit -1 befüllen
        for (int i = 0; i < points.length; i++) {
            // Hier ist points[i][0] der Spaltenindex und points[i][1] der Zeilenindex
            output[ points[i][1] ][ points[i][0] ] = -1;
        }

        return output;
    }

}



