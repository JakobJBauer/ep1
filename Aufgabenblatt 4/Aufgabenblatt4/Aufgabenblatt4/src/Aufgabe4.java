/*
    Aufgabe 4) Rekursion mit eindimensionalen Arrays
*/

import java.util.Arrays;

public class Aufgabe4 {

    private static int getHighestAverage(int[] workArray, int start, int end) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        return -1; //Zeile kann geändert oder entfernt werden.
    }

    private static int getHighestDifference(int[] workArray, int index) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        return -1; //Zeile kann geändert oder entfernt werden.
    }

    private static int[] genArrayWithEvenNumbers(int[] workArray, int index) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        return null; //Zeile kann geändert oder entfernt werden.
    }

    private static boolean containsValue(int[] workArray, int value) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        return false; //Zeile kann geändert oder entfernt werden.
    }

    public static void main(String[] args) {
        int[] array1 = {2, 13, 3, 16, 12, 4, 9, 14};
        System.out.println(getHighestAverage(array1, 0, array1.length - 1));
        System.out.println(getHighestAverage(array1, 4, array1.length - 1));
        System.out.println(getHighestAverage(array1, 1, 4));
        System.out.println(getHighestAverage(array1, 0, 1));
        System.out.println();

        int[] array2 = {33, 23, 53, 29, 12, 34, 41, 44, 28, 13};
        System.out.println(getHighestDifference(array2, 1));
        System.out.println(getHighestDifference(array2, 4));
        System.out.println(getHighestDifference(array2, 6));
        System.out.println(getHighestDifference(array2, 8));
        System.out.println();

        int[] array3 = {35, 12, 7, 15, 20, 5, 50, 15, 26, 8};
        System.out.println(Arrays.toString(array3));
        System.out.println(Arrays.toString(genArrayWithEvenNumbers(array3, 0)));
        System.out.println(Arrays.toString(genArrayWithEvenNumbers(array3, 9)));
        System.out.println(Arrays.toString(genArrayWithEvenNumbers(array3, 8)));
        System.out.println(Arrays.toString(genArrayWithEvenNumbers(array3, 4)));
        System.out.println();

        int[] array4 = {2, 4, 7, 10, -10, 4, 0, 0, 27, 11, 4, 6};
        System.out.println(containsValue(array4, 11));
        System.out.println(containsValue(array4, 2));
        System.out.println(containsValue(array4, 25));
        System.out.println(containsValue(array4, 0));
        System.out.println(containsValue(array4, 14));
        System.out.println(containsValue(array4, 6));

        assert (getHighestAverage(array1, 0, array1.length - 1) == 11);
        assert (getHighestAverage(array1, 4, array1.length - 1) == 9);
        assert (getHighestAverage(array1, 1, 4) == 11);
        assert (getHighestAverage(array1, 0, 1) == 0);

        assert (getHighestDifference(array2, 1) == 30);
        assert (getHighestDifference(array2, 4) == 22);
        assert (getHighestDifference(array2, 6) == 16);
        assert (getHighestDifference(array2, 8) == 15);

        assert (Arrays.equals(genArrayWithEvenNumbers(array3, 0), new int[]{0, 12, 0, 0, 20, 0, 50, 0, 26, 8}) == true);
        assert (Arrays.equals(genArrayWithEvenNumbers(array3, 9), new int[]{35, 12, 7, 15, 20, 5, 50, 15, 26, 8}) == true);
        assert (Arrays.equals(genArrayWithEvenNumbers(array3, 8), new int[]{35, 12, 7, 15, 20, 5, 50, 15, 26, 8}) == true);
        assert (Arrays.equals(genArrayWithEvenNumbers(array3, 4), new int[]{35, 12, 7, 15, 20, 0, 50, 0, 26, 8}) == true);

        assert (containsValue(array4, 11) == true);
        assert (containsValue(array4, 2) == true);
        assert (containsValue(array4, 25) == false);
        assert (containsValue(array4, 0) == true);
        assert (containsValue(array4, 14) == false);
        assert (containsValue(array4, 6) == true);
    }
}

