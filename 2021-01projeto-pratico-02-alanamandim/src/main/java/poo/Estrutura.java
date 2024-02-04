package poo;

import java.io.Serializable;
import java.util.HashMap;


public abstract class Estrutura implements Serializable {
    protected String nome;
    protected HashMap<String,String>dados;
    public int lig;

    public Estrutura(String name){
        this. nome = name;
        this.dados = new HashMap<>();

    }
    public String adicionaDados(String tipo, String nomeDados){
        return this.dados.put(tipo,nomeDados);
    }

    public String getNome(){ return nome;}

    public String getDados(String tipo){return this.dados.get(tipo);}

    public String removeDados(String tipo){
        return this.dados.remove(tipo);
    }

    public String listaDados(){
        StringBuilder sb = new StringBuilder();
        // percorrer o HashMap e concatenar no sb
//        nomeAtributo = valorAtributo ;\n

        this.dados.forEach((k,v)-> sb.append(k + "=\"" + v + "\"; "));

        return sb.toString();
    }
    public String listaDadosSub(){
        StringBuilder sb = new StringBuilder();
        this.dados.forEach((k,v)->sb.append("    "+v+"\n"));
        return sb.toString();
    }

}
