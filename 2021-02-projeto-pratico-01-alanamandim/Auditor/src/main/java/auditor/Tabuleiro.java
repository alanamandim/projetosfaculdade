package auditor;

public class Tabuleiro {
    private final int  dimensao =8;
    public boolean verificaMov(double x, double y) {
        return x <= dimensao && y <= dimensao;
    }
    public double getDimensaoX(){return dimensao;}
}
