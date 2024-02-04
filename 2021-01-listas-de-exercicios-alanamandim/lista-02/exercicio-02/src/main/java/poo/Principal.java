package poo;

import java.util.Scanner;

import edu.princeton.cs.algs4.StdDraw;


public class Principal {
    public static void main(String[] args) {
        Scanner dados = new Scanner(System.in);

        while (dados.hasNext()) {
            String linha = dados.nextLine();
            String[] stringSeparada = linha.split(" ");

            double cordenadaX = Double.parseDouble(stringSeparada[0]);
            double cordernadaY = Double.parseDouble(stringSeparada[1]);
            double raio = Double.parseDouble(stringSeparada[2]);

            StdDraw.circle(cordenadaX, cordernadaY, raio);

        }
    }
}
