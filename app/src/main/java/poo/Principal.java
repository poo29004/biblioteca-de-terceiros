package poo;
import edu.princeton.cs.algs4.Draw;

public class Principal {

    public static void main(String[] args) {

        Draw draw = new Draw();
        
        // Lendo argumentos de linha de comando
        if (args.length > 0 ) {
            draw.text(.3, .3, args[0]);
        }

        draw.square(0.5, 0.5, 0.5);
        draw.setPenColor(Draw.BLUE);
        draw.line(0.5, 0.5, 0.9, 0.5);
        draw.line(0.9, 0.5, 0.5, 0.8);
        draw.line(0.5, 0.8, 0.5, 0.5);
        draw.circle(0.7, 0.65, 0.25);
    }
}
