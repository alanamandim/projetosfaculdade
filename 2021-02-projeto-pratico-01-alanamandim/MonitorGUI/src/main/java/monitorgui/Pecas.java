package monitorgui;

public enum Pecas {
    ROBO("robo.png",0,0),
    ROBO1("robo2.png",6,6),
    BANDEIRA1("bandeira.png",0.0,6.0),
    BANDEIRA2("bandeira.png",3.0,3.0),
    BANDEIRA3("bandeira.png",6.0,0.0);

    public String figura;
    public double x;
    public double y;

    Pecas(String fig, double x,double y){
        this.figura = fig;
        this.x = x;
        this.y = y;
    }

}