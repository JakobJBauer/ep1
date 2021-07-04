/*
    Aufgabe 4) Rekursion
*/
public class Aufgabe4 {

    private static int countCharsSmaller(String text, char value) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        if(text == "") return 0;
        String n1Text = text.length() > 1 ? text.substring(1) : "";
        return (text.charAt(0) < value ? 1 : 0) + countCharsSmaller(n1Text, value);
    }

    private static String removeCharsInString(String text, char start, char end) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        if(text == "") return "";
        String n1Text = text.length() > 1 ? text.substring(1) : "";
        if(text.charAt(0) < end && text.charAt(0) > start) return removeCharsInString(n1Text, start, end);
        return "" + text.charAt(0) + removeCharsInString(n1Text, start, end);
    }

    private static String shiftDigitRight(String text) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        if(text.length() <= 1) return text;
        String n2Text = text.length() > 2 ? text.substring(2) : "";
        if(text.charAt(0) > 57 || text.charAt(0) < 48) return text.charAt(0) + shiftDigitRight(text.substring(1));
        return text.charAt(1) + shiftDigitRight("" + text.charAt(0) + n2Text);
    }

    public static void main(String[] args) {
        System.out.println(countCharsSmaller("DAS (ist) ]ein] Test!", (char) 100));
        System.out.println(countCharsSmaller("a!", (char) 200));
        System.out.println(countCharsSmaller("Ein Test", (char) 100));
        System.out.println();

        System.out.println(removeCharsInString("testtrompete", 'd', 'n'));
        System.out.println(removeCharsInString("test", 's', 'u'));
        System.out.println(removeCharsInString("t", 't', 't'));
        System.out.println(removeCharsInString("angabe", 'a', 'z'));
        System.out.println();

        System.out.println(shiftDigitRight("az3kj"));
        System.out.println(shiftDigitRight("kjdn{nd8xngs+d#k"));
        System.out.println(shiftDigitRight(""));
        System.out.println(shiftDigitRight("4"));
        System.out.println(shiftDigitRight("ji)oiepk(2"));
        System.out.println(shiftDigitRight("ohneziffer"));

        assert (countCharsSmaller("DAS (ist) ]eine] Test!", (char) 100) == 12);
        assert (countCharsSmaller("a!", (char) 200) == 2);
        assert (countCharsSmaller("Ein Test", (char) 100) == 3);

        assert (removeCharsInString("testtrompete", 'd', 'n').equals("tsttropt"));
        assert (removeCharsInString("test", 's', 'u').equals("es"));
        assert (removeCharsInString("t", 't', 't').equals("t"));
        assert (removeCharsInString("angabe", 'a', 'z').equals("aa"));

        assert (shiftDigitRight("az3kj").equals("azkj3"));
        assert (shiftDigitRight("kjdn{nd8xngs+d#k").equals("kjdn{ndxngs+d#k8"));
        assert (shiftDigitRight("").equals(""));
        assert (shiftDigitRight("4").equals("4"));
        assert (shiftDigitRight("ji)oiepk(2").equals("ji)oiepk(2"));
        assert (shiftDigitRight("ohneziffer").equals("ohneziffer"));
    }
}
