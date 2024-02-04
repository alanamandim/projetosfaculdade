
import edu.princeton.cs.algs4.StdDraw;

public class TorreCelular {

    private double x;
    private double y;
    private  double raio;

    private double ponto;
    private double px;
    private double py;
    public double incorreto;

    public TorreCelular(double tx, double ty, double tRaio) {
        if (0 <= tx && 600 >= tx) {

            if (0 <= tx && 600 >= tx) {

                if (0 <= raio && 600 >= raio) {

                    this.x = tx;
                    this.y = ty;
                    this.raio = tRaio;
                } else {
                    incorreto = 1;
                }
                ;
            } else {
                incorreto = 1;
            }
            ;
        } else {
            incorreto = 1;
        }

    }
    public double getVerificador(){
        return incorreto;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRaio() {
        return raio;
    }

    public boolean verificadorPonto (double cordX, double cordy){
        this.px = cordX;
        this.py=cordy;

        double ponto = Math.sqrt(Math.pow((px-x),2)+Math.pow((py-y),2));

        return ponto <=raio;


    }

}
