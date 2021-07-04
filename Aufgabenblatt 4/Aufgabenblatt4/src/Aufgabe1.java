/*
    Aufgabe 1) Code Analyse - Eindimensionale Arrays
*/
public class Aufgabe1 {
    
    private static void genArray(int[] filledArray){
        int value = 5;
        for (int i = 0; i < filledArray.length; i++) {
            filledArray[i] = value;
            value += 5;
        }
    }
    
    private static void printFilteredArrayContent(int[] workArray){
        int[] copiedArray = workArray;
        for (int i = 0; i < copiedArray.length; i++) {
            if(copiedArray[i] % 4 == 0){
                copiedArray[i] = 0;
            }
        }
        printArray(copiedArray);
    }
    
    private static void genNewArrayContent(int[] workArray){
        int[] helpArray = new int[15];
        int value = 7;
        for (int i = 0; i < helpArray.length; i++) {
            helpArray[i] = value;
            value += 7;
        }
        workArray = helpArray;
        printArray(workArray);
    }
    
    private static void printArray(int[] workArray){
        for (int i = 0; i < workArray.length; i++) {
            System.out.print(workArray[i]+ " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] filledArray = new int[15];
        genArray(filledArray);
        printArray(filledArray);
        
        printFilteredArrayContent(filledArray);
        printArray(filledArray);
        
        filledArray[0] = 2020;
        printArray(filledArray);
        
        genNewArrayContent(filledArray);
        printArray(filledArray);
    }
    
    //**************************************************************************
    //**** Notizen und Fragebeantwortungen bitte hier unterhalb durchführen! ***
    //**************************************************************************
    //Frage 1: Fehler da i<=workArray.length als Grenzwert festgelegt wurde und i runtergezählt wird.
    //
    //Frage 2: Da der Methode die Adresse des Arrays mitgegeben wurde. Dadurch werden änderungen an diesem Array auch
    //          in der mein funktion "übernommen"
    //Frage 3: Da die Methode printFilteredArrayContent die Methode printArray aufruft, und dadurch den workArray auf
    //          die kopierte Variente des Arrays setzt. Dadurch wird dieser wieder Ausgegeben.
    //Frage 4: Anfangs wird in der Methode "getNewArrayContent" ein neuer Array "helpArray" angelegt, während die Adr.
    //          des WorkArrays auf die Adresse des filledArrays gesetzt wurde. Am Ende wir die Adresse den workArrays
    //          auf die Adresse des helpArrays gesetzt und anschließend geprinted, was den filledArray nicht beeinflusst

    // Zusatzfragen:
    // 1. Integer
    // 2. Ja
    // 3. Garnicht
    // 4. Array.copy
    // 5. Ja
    // 6. Nein, da dann die Adresse der beiden Arrays verglichen wird
}
