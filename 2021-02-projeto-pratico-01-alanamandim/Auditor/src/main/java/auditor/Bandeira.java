package auditor;

public class Bandeira {
    private double x;
    private double y;
    private boolean capturado;

    public Bandeira(double x, double y){
        this.x = x;
        this.y = y;
        this.capturado = false;
    }

    public double getX(){ return x;}

    public double getY(){ return y;}

    public boolean getCapturado(){ return capturado;}
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y){ this.y = y;}

    public void setCapturado() {
        this.capturado = true;
    }


    public void setCapturado1() {
        this.capturado = true;
    }
}
