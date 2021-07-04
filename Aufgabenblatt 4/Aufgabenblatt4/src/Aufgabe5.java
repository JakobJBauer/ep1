/*
    Aufgabe 5) Eindimensionale Arrays und File I/O
*/

import java.awt.*;

public class Aufgabe5 {

    private static String[] readFileData(String fileName, int lineStart, int lineEnd) {
        In fileReader = new In(fileName);
        String[] content = new String[lineEnd - lineStart + 1];
        for (int i = 1; i < lineStart; i++) { // Skips lines until lineStart
            fileReader.readLine();
        }
        for (int i = 0; i < lineEnd - lineStart + 1; i++) {
            content[i] = fileReader.readLine();
        }
        return content;
    }

    private static void extractData(String[] dataArray, int[] resultArray, int numColumn, int entriesPerYear) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        for (int i = 0; i < resultArray.length; i++) {
            int sumPerYear = 0;
            for (int j = 0; j < entriesPerYear; j++) {
                sumPerYear += Integer.parseInt(getColumnContent(dataArray[i * entriesPerYear + j], numColumn));
            }
            resultArray[i] = sumPerYear;
        }
    }

    private static String getColumnContent(String row, int numColumn) {
        String[] columns = row.split(";");
        return columns[numColumn];
    }

    private static void drawChart(int[] sunHours) {
        int width = 1275;
        int height = 600;
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);

        //TODO: Implementieren Sie hier Ihre Lösung für die Angabe

        StdDraw.setFont(new Font("Times", Font.PLAIN, 10));

        // Draw yellow Rectangels
        StdDraw.setPenColor(StdDraw.ORANGE);
        for (int i = 0; i < sunHours.length; i++) {
            StdDraw.filledRectangle(
                    (30 + i * 20 + 15/2.00),
                    (sunHours[i]/8.00 + 5),
                    (15/2.00),
                    (sunHours[i]/8.00)
                    );
        }

        // Draw guiding Line
        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 0; i < sunHours.length - 1; i++) {
            StdDraw.line(
                    30 + i * 20 + 15/2.00, (sunHours[i]/4.00) + 5,
                    30 + (i + 1 ) * 20 + 15/2.00, (sunHours[i + 1]/4.00) + 5
                    );
        }

        // Draw min and max Line
        StdDraw.setPenRadius(0.002);
        int min = getMinValue(sunHours), max = getMaxValue(sunHours);

        StdDraw.line(
                30, (min/4.00) + 5,
                width - 30, (min/4.00) + 5
                );
        StdDraw.text(15, min/4.00 + 5, Integer.toString(min));
        StdDraw.text(width - 15, min/4.00 + 5, Integer.toString(min));

        StdDraw.line(
                30, (max/4.00) + 5,
                width - 30, (max/4.00) + 5
                );
        StdDraw.text(15, max/4.00 + 5, Integer.toString(max));
        StdDraw.text(width - 15, max/4.00 + 5, Integer.toString(max));

        // Name every column with a year
        for (int i = 0; i < sunHours.length; i++) {
            StdDraw.text(30 + i * 20 + 15/2.00, 15, String.format("%02d", (i + 55) % 100));
        }
    }

    private static int getMinValue(int[] values) {
        int min = values[0];
        for (int value : values) {
            if (value < min) min = value;
        }
        return min;
    }

    private static int getMaxValue(int[] values) {
        int max = values[0];
        for (int value : values) {
            if (value > max) max = value;
        }
        return max;
    }

    public static void main(String[] args) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Angabe

        String[] data = readFileData("weather_data.csv", 2, 733);
        int[] resultArray = new int[61];
        extractData(data, resultArray, 16, 12);

        drawChart(resultArray);
    }
}
