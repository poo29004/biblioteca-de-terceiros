package poo;
import edu.princeton.cs.algs4.StdDraw;

public class Principal {

    public static void main(String[] args) {
        
        // Lendo argumentos de linha de comando
        if (args.length > 0 ) {
            StdDraw.text(.3, .3, args[0]);
        }

        StdDraw.square(0.5, 0.5, 0.5);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.line(0.5, 0.5, 0.9, 0.5);
        StdDraw.line(0.9, 0.5, 0.5, 0.8);
        StdDraw.line(0.5, 0.8, 0.5, 0.5);
        StdDraw.circle(0.7, 0.65, 0.25);
    }
}
