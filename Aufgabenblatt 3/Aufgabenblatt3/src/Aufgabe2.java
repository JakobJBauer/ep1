/*
    Aufgabe 2) Überladen von Methoden
*/
public class Aufgabe2 {

    private static void addSeparator(String text, char separator) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        String output = "";
        if(text.length() != 0) output += text.charAt(0);
        for (int i = 1; i < text.length(); i++) {
            output += "" + separator + text.charAt(i);
        }
        System.out.println("output = " + output);
    }

    private static void addSeparator(int number, char separator) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        addSeparator(Integer.toString(number), separator);
    }

    private static void addSeparator(String text, String separators) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        for (int i = 0; i < separators.length(); i++) {
            addSeparator(text, separators.charAt(i));
        }
    }

    private static void addSeparator(String text) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        addSeparator(text, '$');
    }

    public static void main(String[] args) {
        String text0 = "A";
        String text1 = "AB";
        String text2 = "Hello!";
        String text3 = "-Java-";
        String text4 = " TEST ";

        addSeparator(text0, '?');
        addSeparator(text1, ',');
        addSeparator(text2, ':');
        addSeparator(text3, '-');
        addSeparator(text4, '+');

        addSeparator(1, '$');
        addSeparator(35, '*');
        addSeparator(657, ':');
        addSeparator(2048, '#');
        addSeparator(26348, '+');

        addSeparator(text1, "+#$");
        addSeparator(text2, ":*&!");

        addSeparator(text0);
        addSeparator(text1);
        addSeparator(text2);
    }
}
