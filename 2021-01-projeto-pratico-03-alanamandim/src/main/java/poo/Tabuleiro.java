package poo;

import edu.princeton.cs.algs4.Draw;

import java.awt.*;

/**
 * Classe a ser herdada por todos as peças
 */
public abstract class Tabuleiro {
    private int jogador;
    private double x;
    private double y;
    private String figura;
    private boolean selecionado;
    private boolean capturado=false;

    public Tabuleiro(int jogador, double x, double y, String picture) {
        this.x = Math.floor(x);
        this.y = Math.floor(y);
        this.figura = picture;
        this.selecionado = false;
        this.jogador = jogador;
    }



    public void desenhar(Draw desenho){
        if(selecionado){
            desenho.filledCircle(x+0.5,y+0.5,.375);
        }
        desenho.picture(x+0.5,y+0.5,figura);


    }

    public abstract boolean checkMovimento(double x, double y);



    public void setCapturado(boolean capturado) {
        this.capturado = capturado;
    }


    public boolean isSelecionado() {
        return selecionado;
    }

    public void marcaDesmarca() {
        this.selecionado = ! this.selecionado;
    }

    public void setSelecionado(boolean selecionado) {
        this.selecionado = selecionado;
    }

    public double getX() {
        return x;
    }

    public boolean isCapturado() {
        return capturado;
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

    public int getJogador() {
        return jogador;
    }


}
