/*
    Aufgabe 3) Rekursion
*/
public class Aufgabe3 {

    private static void printNumbersAscending(int start, int end, int divider) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Methode
        if(start % divider == 0) System.out.println(start);
        if(start <= end) printNumbersAscending(start + 1,end, divider);
    }

    private static void printNumbersDescending(int start, int end, int divider) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Methode
        if(end % divider == 0) System.out.println(end);
        if(start <= end) printNumbersDescending(start, end -1, divider);
    }

    private static int calcCrossSum(int number) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Methode
        String input = Integer.toString(number);
        if(input.length() == 1) return Integer.parseInt(input);
        return Integer.parseInt(input.substring(0, 1)) + calcCrossSum(Integer.parseInt(input.substring(1)));
    }

    private static String duplicateLetterInString(String text, char letter) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Methode
        String nextLetter = (text.length() != 1) ? duplicateLetterInString(text.substring(1), letter) : "";
        if(text.charAt(0) == letter) return "" + text.charAt(0) + text.charAt(0) + nextLetter;
        return "" + text.charAt(0) + nextLetter;
    }

    public static void main(String[] args) {
        printNumbersAscending(10, 20, 2);
        System.out.println();
        printNumbersDescending(5, 15, 3);
        System.out.println();

        System.out.println(calcCrossSum(1));
        System.out.println(calcCrossSum(102));
        System.out.println(calcCrossSum(1234));
        System.out.println(calcCrossSum(10000));
        System.out.println(calcCrossSum(93842));
        System.out.println(calcCrossSum(875943789));
        assert (calcCrossSum(1) == 1);
        assert (calcCrossSum(102) == 3);
        assert (calcCrossSum(1234) == 10);
        assert (calcCrossSum(10000) == 1);
        assert (calcCrossSum(93842) == 26);
        assert (calcCrossSum(875943789) == 60);
        System.out.println();

        System.out.println(duplicateLetterInString("hallo", 'a'));
        System.out.println(duplicateLetterInString("Es ist die Erde", 'e'));
        System.out.println(duplicateLetterInString("3HALLO4", 'L'));
        System.out.println(duplicateLetterInString("a1b2c3d4e5", 'g'));
        assert (duplicateLetterInString("hallo", 'a').equals("haallo"));
        assert (duplicateLetterInString("Es ist die Erde", 'e').equals("Es ist diee Erdee"));
        assert (duplicateLetterInString("3HALLO4", 'L').equals("3HALLLLO4"));
        assert (duplicateLetterInString("a1b2c3d4e5", 'g').equals("a1b2c3d4e5"));
    }
}

