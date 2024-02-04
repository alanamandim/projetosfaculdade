
import edu.princeton.cs.algs4.StdDraw;

import java.util.Scanner;


public class Principal {
    public static void main(String[] args) {

        String px = args[0];
        String py = args[1];
        double pRaio = 2.5;

        Double corPx = Double.parseDouble(px);
        Double cordPy = Double.parseDouble(py);

        TorreCelular torre[] = new TorreCelular[10];

        Scanner dados = new Scanner(System.in);
        int i = 0;


        while (dados.hasNext()) {
            String linha = dados.nextLine();
            String[] stringSeparada = linha.split(" ");

            double cordenadaX = Double.parseDouble(stringSeparada[0]);
            double cordernadaY = Double.parseDouble(stringSeparada[1]);
            double raio = Double.parseDouble(stringSeparada[2]);
            torre[i] = new TorreCelular(cordenadaX, cordernadaY, raio);
            i++;
        }
        StdDraw.setCanvasSize(600, 600); // definindo a área de desenho
        StdDraw.setScale(0, 600); // definindo a escala da área de desenho

        for (int j = 0; j < i; j++) {
            if (torre[j].getVerificador() == 0) {
                StdDraw.setPenColor(StdDraw.RED);
                StdDraw.circle(torre[j].getX(), torre[j].getY(), torre[j].getRaio());
            } else {
                i--;
                System.err.println("Os valores passados na linha : " + (j + 1) + " estão fora do parametro");
            }
        }

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(corPx, cordPy, pRaio);
        int confPonto = 0;
        if (corPx >= 0 && corPx <= 600) {
            if (cordPy >= 0 && corPx <= 600) {
                int encontrado = 0;

                for (int j = 0; j < i; j++) {
                    if (torre[j].verificadorPonto(corPx, cordPy)) {
                        System.out.println(" A torre :" + (j + 1) + " dá cobertura para o ponto informado");
                        j = torre.length;
                        encontrado = 1;
                    }
                }
                if (encontrado == 0) {
                    System.out.println("Não há cobertura para o ponto informado");
                }

            } else {
                confPonto = 1;
            }
        } else {
            confPonto = 1;
        }

        if (confPonto == 1) {
            System.out.println("O ponto informado deve ter as coordenadas entre 0 e 600");
        }


    }
}











