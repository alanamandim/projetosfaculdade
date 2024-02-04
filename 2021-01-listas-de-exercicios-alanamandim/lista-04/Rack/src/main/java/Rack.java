
import java.util.ArrayList;

public class Rack {

    private ArrayList<MaquinaReal>maquinaReals;
    private int posFree;

    Rack(){
        this.posFree = 5;
        this.maquinaReals = new ArrayList<>();

    }

    public boolean adicionaMaqReal( MaquinaReal maq){
        if(this.posFree!=0){
            this.maquinaReals.add(maq);
        }else return    false;
        this.posFree=posFree-1;
        return  true;
    }

    public String toString(){
        StringBuilder serv = new StringBuilder();
        serv.append(" Máquinas reais: " + "\n").append(maquinaReals).append("\n");

    return serv.toString();
    }
}
