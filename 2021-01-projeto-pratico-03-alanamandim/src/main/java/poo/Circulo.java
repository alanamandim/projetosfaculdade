package poo;

import edu.princeton.cs.algs4.Draw;

import java.awt.*;

/**
 * Classe para selecionar a peça
 */
public  class Circulo {
    private double x;
    private double y;
   // private boolean selecionado;

    public Circulo(double x, double y) {
        this.x = Math.floor(x);
        this.y = Math.floor(y);
     //   this.selecionado = false;
    }

    public void desenhar(Draw desenho){
     //   Color cor = (selecionado) ? Color.RED : Color.BLUE;
       Color cor = Color.BLUE;
        desenho.setPenColor(cor);
       }

   /* public boolean isSelecionado() {
        return selecionado;
    }

    public void marcaDesmarca() {
        this.selecionado = ! this.selecionado;
    }

    public void setSelecionado(boolean selecionado) {
        this.selecionado = selecionado;
    }*/

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = Math.floor(x);
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = Math.floor(y);
    }
}
