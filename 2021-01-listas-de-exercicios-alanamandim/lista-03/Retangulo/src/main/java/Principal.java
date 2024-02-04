import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;

public class Principal {
     public static void main(String[] args) {

          // definindo a área de desenho
         StdDraw.setCanvasSize(600,600);
         // definindo a escala da área de desenho
         StdDraw.setScale(0,600);
         int quantRetangulo=4;
         int idRetMudaValor=2;

         Color cor = Color.DARK_GRAY;
         Retangulo retangulo[] = new Retangulo[quantRetangulo];


         retangulo[0] = new Retangulo("200 430 ", "460 560");
         retangulo[1] = new Retangulo("20 15", "250 300");
         retangulo[2] = new Retangulo( "300 300", "500 550");
         retangulo[3] = new Retangulo("300 250", "300 500");

         if(retangulo[idRetMudaValor].alterar("189 300", "300 300")==false){

             System.out.println(" Não foi possivel  alterar os vértices dados inválidos");
         }




         for (int i=0; i<quantRetangulo; i++){
             if(retangulo[i].getVerificador()==1){
                 System.out.println(" As coordenadas passadas no retângulo " +(i+1) +" não formam um retangulo");
             }
             StdDraw.setPenColor(cor);
             StdDraw.line(retangulo[i].getX0(),retangulo[i].getY0(), retangulo[i].getX1(),retangulo[i].getY0());
             //StdDraw.setPenColor(dir);
             StdDraw.line(retangulo[i].getX1(),retangulo[i].getY0(),retangulo[i].getX1(),retangulo[i].getY1());
            // StdDraw.setPenColor(esq);
             StdDraw.line(retangulo[i].getX0(),retangulo[i].getY0(),retangulo[i].getX0(),retangulo[i].getY1());
            // StdDraw.setPenColor(dir);
             StdDraw.line(retangulo[i].getX0(),retangulo[i].getY1(),retangulo[i].getX1(),retangulo[i].getY1());
         }




        // System.out.println(criando);


         



    }
}
