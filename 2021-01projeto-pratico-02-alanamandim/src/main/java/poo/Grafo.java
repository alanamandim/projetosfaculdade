package poo;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Grafo extends Estrutura implements Serializable {

    private HashMap<String, Arco> arcos;
    private HashMap<String, No> nos;
    private HashMap<String, Subgrafo> subgrafos;
    private String label;
    private String labelloc = "t";

    public Grafo(String nome, String label) {
        super(nome);
        this.label = label;
        this.arcos = new HashMap<>();
        this.nos = new HashMap<>();
        this.subgrafos = new HashMap<>();

    }

    public boolean adicionaArco(Arco x) {


        this.nos.forEach((k, v) -> {
            if (k.equals(x.getInicio())) {
                if (v.lig < v.getEquipamentos().qtdMax) {
                    v.lig++;


                } else {
                    x.setVerificador(1);
                }
            }
        });
        if (x.getVerificador() == 0) {
            this.nos.forEach((k, v) -> {
                if (k.equals(x.getFinall())) {
                    if (v.lig < v.getEquipamentos().qtdMax) {
                        v.lig++;


                    } else {
                        this.nos.forEach((key, val) -> {
                            if (k.equals(x.getInicio())) {
                                if (val.lig < val.getEquipamentos().qtdMax && val.lig >= val.getEquipamentos().qtdMin) {
                                    val.lig--;

                                }
                            }
                        });
                    }
                }
            });

            if (x.getVerificador() == 0) {
                this.arcos.put(x.getNome(), x);
                return true;
            }
        }
            return false;

    }

    public boolean deletaArco(String arco) {
        if (this.arcos.containsKey(arco)) {
            this.arcos.remove(arco);
            return true;
        }
        return false;
    }

    public Subgrafo adicionaSubGrafo(Subgrafo z) {
        return this.subgrafos.put(z.getNome(), z);
    }


    public No adicionaNo(No y) {
        return this.nos.put(y.getNome(), y);
    }

    public String listaSubgrafo() {
        StringBuilder sb = new StringBuilder();
        this.subgrafos.forEach((k, v) -> sb.append("subgraph ").append(v.toString() + "\n"));
        return sb.toString();
    }

    public String listaNos() {
        StringBuilder sb = new StringBuilder();
        this.nos.forEach((k, v) -> sb.append(v.toString() + "\n"));
        return sb.toString();
    }

    public String listaArcos() {
        StringBuilder sb = new StringBuilder();
        this.arcos.forEach((k, v) -> sb.append(k + "[ " + v.toString() + "]\n"));
        return sb.toString();
    }


    public boolean verificaNo(String equipBuscar) {
        if (this.nos.containsKey(equipBuscar)) {
            return true;
        }
        return false;
    }

    public boolean verificaConexao(){

       AtomicInteger teste= new AtomicInteger(nos.size());
        this.nos.forEach((k,v)->{
          if(v.getEquipamentos().qtdMin<=v.lig){
             teste.getAndDecrement();
          }
        });
        if(teste.get()==0){
            return true;

        }

        return false;
    }

    public void salvarEmDisco(String nomeArq) {
        File arqDot = new File(nomeArq + ".dot");

        try {
            OutputStream os = (OutputStream) new FileOutputStream(arqDot);
            OutputStreamWriter osw = new OutputStreamWriter(os, StandardCharsets.UTF_8);
            PrintWriter print = new PrintWriter(osw);
            print.println(diagrama());
            print.close();
            osw.close();
            os.close();
        } catch (IOException ex) {
            System.err.println("erro: " + ex.toString());
        }
    }


    public String diagrama() {
        StringBuilder sb = new StringBuilder();
        sb.append("graph ").append(this.nome).append("{\n");
        if (this.label != null) {
            sb.append("label = ").append('"').append(this.label).append('"').append("\n");
        }

        sb.append("labelloc = ").append('"')
                .append(this.labelloc).append('"').append(";\n\n");
        if (listaNos() != null) {
            if(!listaNos().isEmpty()) {
                sb.append(" node [labelloc=c fontsize=10 shape=none]\n");
                sb.append(listaNos());
                sb.append("\n\n");
            }
        }

        if (listaArcos() != null) {
            if(!listaArcos().isEmpty()) {
                this.arcos.forEach((k, v) -> sb.append(v.toString() + "\n"));
                sb.append("\n");
            }
        }

        if (listaSubgrafo() != null) {
            if (!listaSubgrafo().isEmpty()) {
                sb.append(listaSubgrafo());
                sb.append("\n}");
            }
        }
        sb.append("\n");
        return sb.toString();
    }
}
