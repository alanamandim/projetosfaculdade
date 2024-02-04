package engtelecom.std.projetofinal.resources;

import engtelecom.std.projetofinal.exceptions.DispositivoNaoEncontradoException;

import java.util.ArrayList;

public class Ambientes  {
    private String nome;

    private ArrayList<Dispositivo>equip=new ArrayList<>();



   public Ambientes(String nome){
       this.nome = nome;
   }
    public Ambientes(){}

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setEquipa(Dispositivo equip) {
       this.equip.add(equip);
    }

    public ArrayList<Dispositivo> getDispositivos() {

                return equip;
    }

    public void setDispositivoLampada(Lampada disp, int id){
        equip.add(BancoDeDados.verificaLampada(disp, id));
    }
    public void setDispositivoCortina(Cortina disp, int id){
        equip.add(BancoDeDados.verificaCortina(disp, id));
    }
    public void setDispositivoTelevisao(Televisao disp, int id){
        equip.add(BancoDeDados.verificaTelevisao(disp, id));
    }
    public void setDispositivoSom(Som disp, int id){
        equip.add(BancoDeDados.verificaSom(disp, id));
    }
    public void setDispositivoArcondicionado(ArCondicionado disp, int id){
        equip.add(BancoDeDados.verificaArcondicionado(disp, id));
    }
    public void setDispositivoPortao(Portao disp, int id){
        equip.add(BancoDeDados.verificaPortao(disp, id));
    }

   public void excluiDispositivo(int id){
       equip.removeIf(d -> d.getId() == id);
   }


    public void adicionaDispositivo(int id){
       // banco=bancoDeDados.getBancodeDados();
        for( Dispositivo d: BancoDeDados.bancodeDados){
            if(d.getId()==id){
                System.out.println(d);
                this.equip.add(d);
            }
        }
       }


    public Dispositivo buscaDispositivoPeloId(int id) {
       for(Dispositivo d : equip){
           if(d.getId()==id){
               return d;

           }
       }throw new DispositivoNaoEncontradoException(id);

    }


}
