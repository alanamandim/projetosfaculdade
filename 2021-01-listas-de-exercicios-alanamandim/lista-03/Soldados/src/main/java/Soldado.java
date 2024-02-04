public class Soldado {

    public String nome;
    public String nomeclatura;
    private static int qtdTropa;
    private int dist;
    private int movPadrao = 10;
    private final String armPadrao = "fuzil";
    private String armSoldado;


    public  Soldado( String name ){
        this.nome=name;
        qtdTropa++;
    }


    public void movimentar(int passos){
        if(passos !=0){
            this.dist=this.dist+passos;
        }else{
            this.dist=this.dist+movPadrao;
        }


    }
    public boolean atacar(String arma){
        if((qtdTropa < 3) || (qtdTropa > 10)){
            return false;
        }
        this.armSoldado = arma;
        return true;
    }
    public void atacar(){ this.atacar(armPadrao);}

    public  String getNome() {
        return nome;
    }

    public int getDist() {
        return dist;
    }

    public int getMovPadrao() {
        return movPadrao;
    }

    public static int getQtdTropa() {
        return qtdTropa;
    }

    public String getArmPadrao() {
        return armPadrao;
    }

    public String getArmSoldado() {
        return armSoldado;
    }


}
