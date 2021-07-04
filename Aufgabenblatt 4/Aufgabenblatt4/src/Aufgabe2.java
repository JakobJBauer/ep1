/*
    Aufgabe 2) Eindimensionale Arrays
*/
public class Aufgabe2 {

    public static void main(String[] args) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Angabe

        // a
        int[] Array = {1, 4, 7, 0, 3, 6, 2, 8};
        printArray(Array, ',');

        // b
        int[] ArrayB = new int[20];
        for (int i = 0; i < ArrayB.length; i++) ArrayB[i] = (4*i+12)%9==0 ? 0 : 4*i + 12;
        printArray(ArrayB, ' ');

        // c
        int[] ArrayC = {4, 8, 1, 5, 2};
        int[] ArrayD = new int[ArrayC.length + 2];
        ArrayD[0] = 100;
        ArrayD[ArrayD.length - 1] = 200;
        for (int i = 0; i < ArrayC.length; i++) {
            ArrayD[i+1] = ArrayC[i];
        }
        printArray(ArrayD, ' ');

        // d
        int[] ArrayE = new int[15];
        for (int i = 0; i < ArrayE.length; i++) {
            ArrayE[i] = 15 - i;
        }
        System.out.print("while-Schleife:");
        int j = 0;
        while (j < ArrayE.length) {
            System.out.print(" " + ArrayE[ArrayE.length - j - 1]);
            j++;
        }
        System.out.print("\nfor-Schleife:");
        for (int i = 0; i < ArrayE.length; i++) System.out.print(" " + ArrayE[ArrayE.length - i - 1]);
        System.out.println();

        // e
        int[] ArrayF = {61, 13, 19, 10, 2, 33, 41, 73, 0, 56, 94, 6, 45, 84, 23};
        int min = ArrayF[0], max = ArrayF[0], sum = ArrayF[0];
        for (int i = 1; i < ArrayF.length; i++) {
            min = Math.min(min, ArrayF[i]);
            max = Math.max(max, ArrayF[i]);
            sum += ArrayF[i];
        }
        int avg = sum/ArrayF.length; // Angabe sagt int ???????????????????????????????????????
        int[] ArrayG = {min, avg, max};
        printArray(ArrayF, ' ');
        printArray(ArrayG, ' ');
    }

    /**
     *
     * @param Array Array that should be printed to the console
     * @param seperator Seperator to add between each element of the array
     */
    private static void printArray(int[] Array, char seperator) {
        if (Array.length == 0) return;
        for (int i = 0; i < Array.length - 1; i++) {
            System.out.print("" + Array[i] + seperator);
        }
        System.out.println(Array[Array.length - 1]);
    }
}

