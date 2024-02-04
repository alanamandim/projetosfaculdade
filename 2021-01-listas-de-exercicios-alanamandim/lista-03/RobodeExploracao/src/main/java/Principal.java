import edu.princeton.cs.algs4.StdDraw;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        final double altura;
        final double largura;
        int qtdlinhas=14;

        Scanner dados = new Scanner(System.in);
        int i=0;
        String[] inf = new String[qtdlinhas];


        while (dados.hasNext()) {
            String linha = dados.nextLine();
            inf[i]=linha;
            i++;
        }
        double x0,y0,tam;
        String direct;

        String [] stringSeparada = inf[0].split(" ");
        tam=Double.parseDouble(stringSeparada[0]);
        x0 = Double.parseDouble(stringSeparada[1]);
        y0 = Double.parseDouble(stringSeparada[2]);
        direct = stringSeparada[3];
        altura=tam;
        largura=tam;

        StdDraw.setCanvasSize((int)largura,(int)altura);
        StdDraw.setScale(0, largura);

        Robo robo = new Robo(tam,x0,y0,direct);

        for( int j=1;j<i;j++) {
            if (inf[j].equals("M")) {
                if (!robo.movimento()) {
                    System.out.println("Não é possível se locomover nessa área");
                } else {
                    StdDraw.line(robo.getxAnt(), robo.getyAnt(), robo.getX(), robo.getY());
                    StdDraw.pause(1000);
                    System.out.println("O robo se locomoveu");
                }
            }
            if (inf[j].equals("D")) {
                robo.movDireita();
                System.out.println("O robo virou para a direita");
            }
            if (inf[j].equals("E")) {
                robo.movEsqerda();
                System.out.println("O robo virou para a esquerda");
            }
        }
        System.out.println("O trajeto acbou! O robo parou na coordenada: " + "\n" +
                robo.getX() + " , " + robo.getY() + ". Direcionado para: " + robo.getDir());

    }

}
