package poo;

import java.io.Serializable;

public class Arco extends Estrutura implements Serializable {
    private String inicio;
    private String finall;
    private int verificador=0;

    public Arco(String nome, String inicio,String finall){
        super(nome);
        this.inicio = inicio;
        this.finall = finall;
    }

    public String getFinall() {
        return finall;
    }

    public String getInicio() {
        return inicio;
    }

    public int getVerificador(){return verificador;}

    public void setVerificador(int verificador) {
        this.verificador = verificador;
    }

    @Override
    public String toString(){
        return inicio + "--" + finall + this.listaDados() ;
    }


}
