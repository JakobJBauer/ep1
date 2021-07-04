/*
    Aufgabe 4) Rekursion + Zweidimensionale Arrays - primitive Landschaftssimulation
*/

import java.awt.*;

public class Aufgabe4 {

    private static final int canvasSize = 500;

    private static Color[][] genLandscape(int size) {
        Color[][] landscape = new Color[size][size];
        for (int i = 0; i < landscape.length; i++)
            for (int j = 0; j < landscape[i].length; j++)
                landscape[i][j] = Math.random() <= 0.1 ? Color.GRAY : Color.GREEN;
        return landscape;
    }

    private static void drawLandscape(Color[][] landscape) {
        for (int i = 0; i < landscape.length; i++) {
            for (int j = 0; j < landscape[i].length; j++) {
                StdDraw.setPenColor(landscape[i][j]);
                StdDraw.filledSquare(
                        j * canvasSize/(1.00 * landscape.length - 1),
                        i * canvasSize/(1.00 * landscape.length - 1),
                        canvasSize/(2.00 * landscape.length)
                );
            }
        }
    }

    private static void simLiquidFlow(Color[][] landscape, int x, int y) {
        if(y < 0 || x < 0) return;
        if (landscape[y][x] == Color.BLACK) return;
        if (landscape[y][x] == Color.GRAY) {
            if(y+1 < landscape.length) landscape[y+1][x] = Color.ORANGE;
            landscape[y][x] = Color.BLACK;
            simLiquidFlow(landscape, x + 1, y - 1);
            simLiquidFlow(landscape, x - 1, y - 1);
        }
        else {
            landscape[y][x] = Color.ORANGE;
            if (Math.random() >= 0.5) simLiquidFlow(landscape, x + 1, y - 1);
            else simLiquidFlow(landscape, x - 1, y - 1);
        }
    }

    private static void simSpreadingFire(Color[][] landscape, int x, int y) {
        if (landscape[y][x] == Color.GREEN) landscape[y][x] = Color.RED;
        else if(landscape[y][x] == Color.ORANGE) {
            spreadFireInLiquid(landscape, x, y);
            return;
        }
        else return;
        if(Math.random() >= 0.4 && y-1 >= 0) simSpreadingFire(landscape, x, y-1);
        if(Math.random() >= 0.4 && y+1 < landscape.length) simSpreadingFire(landscape, x, y+1);
        if(Math.random() >= 0.4 && x-1 >= 0) simSpreadingFire(landscape, x-1, y);
        if(Math.random() >= 0.4 && x+1 < landscape[y].length) simSpreadingFire(landscape, x+1, y);
    }

    private static void spreadFireInLiquid(Color[][] landscape, int x, int y) {
        if(y < 0 || y >= landscape.length || x < 0 || x >= landscape[y].length) return;
        if (landscape[y][x] == Color.ORANGE) {
            landscape[y][x] = Color.RED;
            spreadFireInLiquid(landscape, x + 1, y + 1);
            spreadFireInLiquid(landscape, x + 1, y - 1);
            spreadFireInLiquid(landscape, x - 1, y + 1);
            spreadFireInLiquid(landscape, x - 1, y - 1);
            spreadFireInLiquid(landscape, x, y - 1);
            spreadFireInLiquid(landscape, x, y + 1);
            spreadFireInLiquid(landscape, x - 1, y);
            spreadFireInLiquid(landscape, x + 1, y);
        }
    }

    public static void main(String[] args) {
        StdDraw.setCanvasSize(canvasSize, canvasSize);
        StdDraw.setScale(0, canvasSize);
        StdDraw.enableDoubleBuffering();

        int size = 100;
        Color[][] landscape = genLandscape(size);

        simLiquidFlow(landscape, size / 2, size-1);
        drawLandscape(landscape);
        StdDraw.show();
        StdDraw.pause(1000);

        landscape[75][25] = Color.GREEN;
        simSpreadingFire(landscape, 25, 75);
        drawLandscape(landscape);
        StdDraw.show();
    }
}
