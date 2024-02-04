public class MaquinaVirtual {

    private String nomeMaqVirt;
    private double memRam;
    private int modo;
    private double discRig;

    public MaquinaVirtual(double discUsado, double ramUsado, String nameV){
        this.nomeMaqVirt = nameV;
        this.discRig = discUsado;
        this.memRam = ramUsado;
    }

    public int ligaMaq(){
        this.modo = 1;
        return modo;
    }

    public int desligaMaq(){
        this.modo = 0;
        return  modo;
    }

    public double getMemRam() {
        return memRam;
    }

    public String getNomeMaqVirt() {
        return nomeMaqVirt;
    }

    public double getDiscRig() {
        return discRig;
    }

    public int getModo() {
        return modo;
    }

    public String toString(){
        if(this.modo==1){
            return "Maquina Virtual: " + getNomeMaqVirt() + " está ligada" + "\n" +
                    "Disco Rigido utilizado " + getDiscRig() + " GB e " + getMemRam() + " GB de RAM" + "\n";

        }else return "Maquina virtual: " + getNomeMaqVirt() + " está desligada"+ "\n";
    }
}
