public class Robo {
    private double area;
    private double x;
    private double y;
    private String dir;
    private double xAnt;
    private double yAnt;



    public Robo(double tam, double x0, double y0, String direct){
    this.area=tam;
    if(x0>area ||y0>area){
        this.x=0;
        this.y=0;
        this.dir="N";
    }else{
        this.x=x0;
        this.y=y0;
        this.dir=direct;
    }
    this.yAnt=y;
    this.xAnt=x;

    }

    public String movEsqerda( ) {
        switch (this.dir) {
            case "N":
                this.dir = "O";
                break;
            case "S":
                this.dir = "L";
                break;
            case "O":
                this.dir = "S";
                break;
            case "L":
                this.dir = "N";
                break;
        }
        return dir;
    }

    public String movDireita(){
        switch (this.dir){
            case "N":
                this.dir = "L";
                break;
            case "O":
                this.dir = "N";
                break;
            case "S":
                this.dir = "O";
                break;
            case "L":
                this.dir = "S";
                break;
        }
        return dir;
    }

    public boolean movimento() {
        switch (dir) {
            case "N":
                if (this.area >= y + 10) {
                    xAnt = x;
                    yAnt = y;
                    y = y + 10;
                    return true;
                }
                break;
            case "S":
                if (0 <= y - 10) {
                    xAnt = x;
                    yAnt = y;
                    y = y - 10;
                    return true;
                }
                break;
            case "L":
                if (this.area >= x + 10) {
                    xAnt = x;
                    yAnt = y;
                    x = x + 10;
                    return true;
                }
                break;
            case "O":
                if (0 <= x - 10) {
                    xAnt = x;
                    yAnt = y;
                    x = x - 10;
                    return true;
                }
                break;
        }
        return false;
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getxAnt() {
        return xAnt;
    }

    public double getyAnt() {
        return yAnt;
    }

    public String getDir() {
        return dir;
    }

}