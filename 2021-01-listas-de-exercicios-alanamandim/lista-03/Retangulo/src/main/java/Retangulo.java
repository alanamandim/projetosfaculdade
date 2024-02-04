
public class Retangulo{

    private double x0;
    private double x1;
    private double y0;
    private double y1;
    int verificador =0;
    public Retangulo(String infesq, String supdir) {
        String[] verEsq = infesq.split(" ");
        String[] verDir = supdir.split(" ");

            x0 = Double.parseDouble(verEsq[0]);
            y0 = Double.parseDouble(verEsq[1]);

            x1 = Double.parseDouble(verDir[0]);
            y1 = Double.parseDouble(verDir[1]);
            if(x0==x1 || y0==y1){
                x0=0;
                x1=10;
                y0=0;
                y1=10;
                verificador=1;
            }
        
    }
    public boolean alterar (String infE, String supD){
        String[] verEsq = infE.split(" ");
        String[] verDir = supD.split(" ");
        if(Double.parseDouble(verEsq[0])==Double.parseDouble(verDir[0]) ||Double.parseDouble(verEsq[1])==Double.parseDouble( verDir[1])){
            return false;
        }else{
            this.x0 = Double.parseDouble(verEsq[0]);
            this.y0 = Double.parseDouble(verEsq[1]);
            this.x1 = Double.parseDouble(verDir[0]);
            this.y1 = Double.parseDouble(verDir[1]);
            return true;

        }

    }
    public int getVerificador(){
        return verificador;
    }

    public double getX0() {
        return x0;
    }

    public double getX1() {
        return x1;
    }

    public double getY0() {
        return y0;
    }

    public double getY1() {
        return y1;
    }
}
