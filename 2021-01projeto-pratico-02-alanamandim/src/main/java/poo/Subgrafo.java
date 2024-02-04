package poo;

import java.io.Serializable;

public class Subgrafo  extends Estrutura implements Serializable {

    private String labelSubGrafo;



    public Subgrafo(String nome, String label){
        super(nome);
        labelSubGrafo=label;



    }


    @Override
    public String toString(){
      //  StringBuilder sb = new StringBuilder();
      //  sb.append("label = ").append('"').append(this.label).append('"').append("\n");

     //   sb.append(this.nome + "{\n"+"    label =").append('"').append(labelSubGrafo).append('"')
        return this.nome + "{\n"+"    label = "+ '"'+labelSubGrafo+'"'+"\n"+
            "    labelloc=b\n    fontsize=10\n    style=filled;\n    bgcolor=lightyellow;\n\n"+ listaDadosSub() +"\n}\n";}

}
