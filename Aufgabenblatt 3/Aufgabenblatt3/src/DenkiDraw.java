import java.lang.Math;
public class DenkiDraw {
    public static void main(String[] args) {
        StdDraw.setCanvasSize(512, 512);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.005);

        // 1
        StdDraw.circle(0.5, 0.5, 0.1);

        // 2
        double width = Math.sqrt((0.1 * 0.1) / 2);
        StdDraw.rectangle(0.5, 0.5, width, width); // sqrt(a^2+a^2)=r

        // 3
        drawTriangle(0.5-width, 0.5+width, 0.5+width, 0.5+width, 0.5, 0.5-width);

        // 4
        drawTriangle(0.5-width, 0.5+width, 0.5+width, 0.5+width, 0.5, 0.5);

        // 5
        double hyp = Math.sqrt(0.1*0.1 + 0.1*0.1);
        drawRectangle( // sqrt (r^2+r^2) = d(M, Edge)
                0.5, 0.5 + hyp,0.5 - hyp, 0.5, 0.5, 0.5 - hyp, 0.5 + hyp, 0.5
        );

        // 6
        StdDraw.rectangle(0.5, 0.5, 0.1 * 3,0.1);

        // 7
        StdDraw.ellipse(0.5, 0.5, 0.1 * 3, 0.1);
    }

    private static void drawTriangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        StdDraw.line(x1, y1, x2, y2);
        StdDraw.line(x2, y2, x3, y3);
        StdDraw.line(x3, y3, x1, y1);
    }

    private static void drawRectangle(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        StdDraw.line(x1, y1, x2, y2);
        StdDraw.line(x2, y2, x3, y3);
        StdDraw.line(x3, y3, x4, y4);
        StdDraw.line(x4, y4, x1, y1);
    }
}
