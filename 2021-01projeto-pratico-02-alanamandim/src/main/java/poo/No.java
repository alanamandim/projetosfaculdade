package poo;

import java.io.Serializable;

public class No extends Estrutura implements Serializable {
    private final Equipamentos equipamentos;


    public No(String nome, Equipamentos equipamentos){
        super(nome);
        this.equipamentos = equipamentos;
    }



    public Equipamentos getEquipamentos() {
        return equipamentos;
    }

    @Override
    public String toString(){ return this.nome + " [ " + this.listaDados()+ "]"; }
}
