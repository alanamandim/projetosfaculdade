import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class MaquinaReal {
    private double armDisco;
    private String nomeMaqReal;
    private double memRam;
    private ArrayList<MaquinaVirtual>maquinaVirtuals;

    public MaquinaReal(double memdisco, double ram, String name){
        this.memRam = ram;
        this.nomeMaqReal = name;
        this.armDisco = memdisco;
        this.maquinaVirtuals = new ArrayList<>();
    }

    public String getNomeMaqReal(){
        return nomeMaqReal;
    }

    public  boolean adicionaMaqVirtual(double disco, double ramCon, String nome){
        if(this.armDisco>=disco && this.memRam>=ramCon && this.maquinaVirtuals.size()<5){
            this.maquinaVirtuals.add(new MaquinaVirtual(disco,ramCon,nome));
        }else{
            return false;
        }
        return true;
    }

    public boolean removeMaqVirtual( String nomeRemove){
        for(int j=0; j<this.maquinaVirtuals.size();j++){
            if(this.maquinaVirtuals.get(j).getNomeMaqVirt().equals(nomeRemove)){
                this.maquinaVirtuals.remove(j);
                return true;
            }
        }
        return false;
    }

    public int ligarMaqVirtual(String nomeMv){
        AtomicInteger controle = new AtomicInteger(0);

        this.maquinaVirtuals.forEach(mv -> {
            if(mv.getNomeMaqVirt().equals(nomeMv)){
                mv.ligaMaq();
                controle.set(1);
            }
        });
    return controle.get();
    }

    public int desligarMaqVirtual(String nomeMaq){
        AtomicInteger controle = new AtomicInteger(1);

        this.maquinaVirtuals.forEach(mv -> {
            if(mv.getNomeMaqVirt().equals(nomeMaq)){
                mv.desligaMaq();
                controle.set(0);
            }
        });
        return controle.get();
    }

    public String toString(){
        StringBuilder serv = new StringBuilder();
        serv.append("\n"+"Máquina: ").append(getNomeMaqReal()).append("\n");
        serv.append("Tem: "+ this.armDisco + " GB de disco e "+this.memRam+ " GB de RAM"+"\n");
        serv.append(this.maquinaVirtuals.toString());
        return serv.toString();
    }

}

