package engtelecom.std.projetofinal.resources;

import engtelecom.std.projetofinal.exceptions.DispositivoNaoEncontradoException;

import java.util.ArrayList;

public class Cenario {
    String nome;
    int inicio;
    int fim;
    ArrayList<Dispositivo>dispositivoscen = new ArrayList<>();


    public Cenario(String nome,int inicio, int fim){this.nome = nome; this.inicio = inicio; this.fim = fim;}

 public Cenario(){}

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
            return nome;
    }

    public void setFim(int fim) {
        this.fim = fim;
    }

    public int getFim() {
        return fim;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public int getInicio() {
        return inicio;
    }

    public void excluiDispositivo(int id){
        dispositivoscen.removeIf(d -> d.getId() == id);
    }
    public void setDispositivoLampada(Lampada disp, int id){
        dispositivoscen.add(BancoDeDados.verificaLampada(disp, id));
    }
    public void setDispositivoCortina(Cortina disp, int id){
        dispositivoscen.add(BancoDeDados.verificaCortina(disp, id));
    }
    public void setDispositivoTelevisao(Televisao disp, int id){
       dispositivoscen.add(BancoDeDados.verificaTelevisao(disp, id));
    }
    public void setDispositivoSom(Som disp, int id){
        dispositivoscen.add(BancoDeDados.verificaSom(disp, id));
    }
    public void setDispositivoArcondicionado(ArCondicionado disp, int id){
        dispositivoscen.add(BancoDeDados.verificaArcondicionado(disp, id));
    }
    public void setDispositivoPortao(Portao disp, int id){
        dispositivoscen.add(BancoDeDados.verificaPortao(disp, id));
    }

    public void setDispositivoscen(ArrayList<Dispositivo> dispositivos) {
            this.dispositivoscen = dispositivos;
        }


        public ArrayList<Dispositivo> getDispositivos() {
            return dispositivoscen;
        }
    public Dispositivo buscaDispositivoPeloId(int id) {
        for(Dispositivo d : dispositivoscen){
            if(d.getId()==id){
                return d;

            }
        }throw new DispositivoNaoEncontradoException(id);

    }

    public void adicionaDispositivo(int id){
       // banco=bancoDeDados.getBancodeDados();
        for( Dispositivo d: BancoDeDados.bancodeDados){
            if(d.getId()==id){
                this.dispositivoscen.add(d);
            }
        }
    }





}
