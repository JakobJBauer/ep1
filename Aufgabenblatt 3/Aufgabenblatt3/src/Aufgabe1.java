/*
    Aufgabe 1) Codeanalyse, Codingstyle und Methoden
*/
public class Aufgabe1 {

    private static String sortByASCII(String s) { //f0, Geht den Eingangsstring durch und sortiert alle Werte ihrem ASCII wert nach
        int index = 0;
        String unsortedText = s;
        while (index < getLength(unsortedText)) {
            if (index == 0 || biggerASCII(unsortedText.charAt(index), unsortedText.charAt(index - 1))) {
                index = sum(index, 1);
            } else {
                unsortedText = substring(unsortedText, 0, index - 1) + unsortedText.charAt(index) + unsortedText.charAt(index - 1) + substring(unsortedText, index + 1, getLength(unsortedText));
                index = sum(index, -1);
            }
        }
        return unsortedText;
    }

    private static int getLength(String s) { //f1, gibt die Länge des Eingabeparametes zurück
        return s.length();
    }

    private static int sum(int n, int s) { //f2, addiert zwei Eingabeparameter und gibt den Wert zurück
        return n + s;
    }

    private static boolean biggerASCII(char c1, char c2) { //f3, vergleicht ob der ACII wert des ersten Paramteres größer als der das zweiten ist
        return c1 >= c2;
    }

    private static String substring(String s, int n1, int n2) { // f4, gibt den Teilstring von s von Index [n1 bis n2) zurück
        return s.substring(n1, n2);
    }

    public static String sortByASCII_improved(String s) {
        for(int i = 0; i < s.length(); ) {
            if (i == 0 || s.charAt(i) >= s.charAt(i-1)) i++;
            else {
                s = s.substring(0, i-1) + s.charAt(i) + s.charAt(i-1) + s.substring(i+1);
                i--;
            }
        }
        return s;
    }

    public static void main(String args[]) {

        System.out.println(sortByASCII("ab"));
        System.out.println(sortByASCII("ba"));
        System.out.println(sortByASCII("aa"));
        System.out.println(sortByASCII("cba"));
        System.out.println(sortByASCII("abababab"));
        System.out.println(sortByASCII("abcfghed"));
        System.out.println(sortByASCII("abnasnasab"));
        System.out.println(sortByASCII("najskaghkkjsfvjhbavbdfsan"));
        System.out.println(sortByASCII("jgbgdsjabkjdbvbdjabkjsavbkjbdsvkjbagfgafjdbv"));

        assert (sortByASCII("ab").equals("ab"));
        assert (sortByASCII("ba").equals("ab"));
        assert (sortByASCII("aa").equals("aa"));
        assert (sortByASCII("cba").equals("abc"));
        assert (sortByASCII("abababab").equals("aaaabbbb"));
        assert (sortByASCII("abcfghed").equals("abcdefgh"));
        assert (sortByASCII("abnasnasab").equals("aaaabbnnss"));
        assert (sortByASCII("najskaghkkjsfvjhbavbdfsan").equals("aaaabbdffghhjjjkkknnsssvv"));
        assert (sortByASCII("jgbgdsjabkjdbvbdjabkjsavbkjbdsvkjbagfgafjdbv").equals("aaaaabbbbbbbbbdddddffggggjjjjjjjjkkkksssvvvv"));

        System.out.println(sortByASCII_improved("ab"));
        System.out.println(sortByASCII_improved("ba"));
        System.out.println(sortByASCII_improved("aa"));
        System.out.println(sortByASCII_improved("cba"));
        System.out.println(sortByASCII_improved("abababab"));
        System.out.println(sortByASCII_improved("abcfghed"));
        System.out.println(sortByASCII_improved("abnasnasab"));
        System.out.println(sortByASCII_improved("najskaghkkjsfvjhbavbdfsan"));
        System.out.println(sortByASCII_improved("jgbgdsjabkjdbvbdjabkjsavbkjbdsvkjbagfgafjdbv"));

        assert (sortByASCII_improved("ab").equals("ab"));
        assert (sortByASCII_improved("ba").equals("ab"));
        assert (sortByASCII_improved("aa").equals("aa"));
        assert (sortByASCII_improved("cba").equals("abc"));
        assert (sortByASCII_improved("abababab").equals("aaaabbbb"));
        assert (sortByASCII_improved("abcfghed").equals("abcdefgh"));
        assert (sortByASCII_improved("abnasnasab").equals("aaaabbnnss"));
        assert (sortByASCII_improved("najskaghkkjsfvjhbavbdfsan").equals("aaaabbdffghhjjjkkknnsssvv"));
        assert (sortByASCII_improved("jgbgdsjabkjdbvbdjabkjsavbkjbdsvkjbagfgafjdbv").equals("aaaaabbbbbbbbbdddddffggggjjjjjjjjkkkksssvvvv"));
    }
}


