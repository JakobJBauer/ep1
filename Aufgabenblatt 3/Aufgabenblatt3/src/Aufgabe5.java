/*
    Aufgabe 5) Kreuzmuster mit Rechtecken => Rekursiv vs. Iterativ
*/

public class Aufgabe5 {

    private static void drawPatternRecursive(int x, int y, int l, boolean c) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        if(l < 16) return;

        double width = l * 0.05;

        drawPatternRecursive(x - l/4, y - l/4, l/2, !c);
        drawPatternRecursive(x + l/4, y - l/4, l/2, !c);
        drawPatternRecursive(x - l/4, y + l/4, l/2, !c);
        drawPatternRecursive(x + l/4, y + l/4, l/2, !c);

        StdDraw.setPenColor(c ? StdDraw.ORANGE : StdDraw.BLUE);

        StdDraw.filledRectangle(x/512.0 + 0.5, y/512.0 + 0.5, l/(512.0 * 2), width/(512.0 * 2));
        StdDraw.filledRectangle(x/512.0 + 0.5, y/512.0 + 0.5, width/(512.0 * 2), l/(512.0 * 2));
    }

    private static void drawPatternIterative(int width) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode

        // calculate amount of layers
        int layers = 0;
        int pixel = width;
        while(pixel >= 16) {
            pixel /= 2;
            layers++;
        }

        // Calculate the amount of crosses per layer (in one line, not total)
        int[] crossesPerLinePerLayer = new int[layers];
        // First layer has always one cross (array is reversed)
        crossesPerLinePerLayer[crossesPerLinePerLayer.length - 1] = 1;
        for (int i = 1; i < layers; i++) {
            // Each layer has double the amount of crosses in one line than the layer before
            crossesPerLinePerLayer[crossesPerLinePerLayer.length - i - 1] = 2 * crossesPerLinePerLayer[crossesPerLinePerLayer.length - i];
        }

        // Calculate which color the lowest layer has
        boolean hasOrangeColor = layers%2==0;

        // Draw layer by layer, starting from the last
        for (int i = 0; i < layers; i++) {
            StdDraw.setPenColor(hasOrangeColor ? StdDraw.BLUE : StdDraw.ORANGE);
            // Inverse color for next iteration
            hasOrangeColor = !hasOrangeColor;

            // Iterate y Axis
            for (int y = 0; y < crossesPerLinePerLayer[i]; y++) {
                // Iterate x Axis to draw the necessary crosses
                for (int x = 0; x < crossesPerLinePerLayer[i]; x++) {
                    double crossWidth = 1/(crossesPerLinePerLayer[i] * 1.00);
                    StdDraw.filledRectangle(
                            crossWidth/2 + x * crossWidth, // Calc center of each cross
                            crossWidth/2 + y * crossWidth, // Calc center of each cross
                            crossWidth/2,
                            (crossWidth/2) * 0.05
                            );
                    StdDraw.filledRectangle(
                            crossWidth/2 + x * crossWidth, // Calc center of each cross
                            crossWidth/2 + y * crossWidth, // Calc center of each cross
                            (crossWidth/2) * 0.05,
                            crossWidth/2
                    );
                }
            }

        }
    }

    public static void main(String[] args) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        StdDraw.setCanvasSize(512, 512);
        drawPatternRecursive(0, 0, 512, true);
        //drawPatternIterative(512);
    }
}
/*
    Antwort der Zusatzfragen:
1. Da l immer halbiert wird und mit 512 beginnt wird die Methode DrawPatternRecursive insgesamt 5461 Mal aufgerufen
    Dies ergibt sich aus:
        1. 1 mal Hauptprogramm
        2. 2^x = 512 mit x der anzahl der iterarionen => 9
        3. Abgezogen von x mit 2^x = 16 => 4
        4. Einmal zusätzlich da Abbruchbedingung "<", nicht "<=" -> 9-4+1 => 6 Iterationen
        5. Da jede Iteration die Methode 4 mal aufruft ist es 4^6 -> 4096
        6. Zusammen mit dem Aufruf des Hauptprogramms -> Die Methode wird 4097 mal aufgerufen (Probe durch counter passt nicht) //5461

2. 1024
3. Rekursionsaufrufmit x+blabla und y+blabla auskommentieren

*/


