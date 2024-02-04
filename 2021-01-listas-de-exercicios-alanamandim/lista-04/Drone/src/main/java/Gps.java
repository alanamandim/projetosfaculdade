public class Gps {
    private double x0,y0,z0;
    private double x1,y1,z1;

    public Gps(double x,double y, double z){
        this.x0 = x;
        this.y0 = y;
        this.z0 = z;

        this.x1 = x;
        this.y1 = y;
        this.z1 = z;
    }

    public double getX0() {
        return x0;
    }

    public double getY0() {
        return y0;
    }

    public double getZ0() {
        return z0;
    }

    public double getX1() {
        return x1;
    }

    public double getY1() {
        return y1;
    }

    public double getZ1() {
        return z1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public void setZ1(double z1) {
        this.z1 = z1;
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
            sb.append("Coordenadas Atual:" + "(" + getX1() + "," + getY1() + "," + getZ1() + ")" + "\n");

        return sb.toString();
    }
}
