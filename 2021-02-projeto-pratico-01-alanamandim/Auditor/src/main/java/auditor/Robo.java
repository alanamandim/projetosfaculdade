package auditor;

public class Robo {
    private double x;
    private double y;
    int bandeira;
    int id;

    public Robo(int id){
        this.id=id;
        if(id==1) {
            this.x = 0;
            this.y = 0;
            this.bandeira = 0;
        }
        if(id==2){
            this.x = 6;
            this.y = 6;
            this.bandeira = 0;
        }

    }


    public void setBandeira() {
        this.bandeira++;
    }
    public int getBandeira(){return bandeira;}

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x =x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getId(){return id;}


    public void setBandeira1() { this.bandeira = 0;    }
}
