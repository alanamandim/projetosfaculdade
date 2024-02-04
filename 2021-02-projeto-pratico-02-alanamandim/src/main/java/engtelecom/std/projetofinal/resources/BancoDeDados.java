package engtelecom.std.projetofinal.resources;

import engtelecom.std.projetofinal.exceptions.DispositivoNaoEncontradoException;

import java.util.ArrayList;

public  class BancoDeDados {
     public static ArrayList<Dispositivo> bancodeDados;




    public BancoDeDados(){
        this.bancodeDados = new ArrayList<>();
        adicionaequip();
    }
    public Dispositivo buscaPeloId(int id){
        for(Dispositivo d: bancodeDados){
            if(d.getId()==id){
                return d;
            }
        }throw new DispositivoNaoEncontradoException(id);

    }
    public static Lampada verificaLampada(Lampada disp, int id) {
        for (Dispositivo d : bancodeDados) {
            if (d.getId() == id) {
                d.setId(id);
                d.setNome(disp.getNome());
                ((Lampada) d).setLuminosidade(((Lampada) disp).getLuminosidade());
                ((Lampada) d).setLigar(((Lampada) disp).isLigar());
                return (Lampada) d;


            }

        }
        throw new DispositivoNaoEncontradoException(id);
    }

    public static Cortina verificaCortina(Cortina disp, int id) {
            for (Dispositivo d : bancodeDados) {
                if (d.getId() == id) {
                    d.setId(id);
                    d.setNome(disp.getNome());
                    ((Cortina) d).setAberta(((Cortina) disp).getAberta());
                    return (Cortina) d;
            }

        }
        throw new DispositivoNaoEncontradoException(id);
    }

    public static Televisao verificaTelevisao(Televisao disp, int id) {
            for (Dispositivo d :bancodeDados) {
                if (d.getId() == id) {
                    d.setId(id);
                    d.setNome(disp.getNome());
                    ((Televisao) d).setVolume(((Televisao) disp).getVolume());
                    ((Televisao) d).setCanal(((Televisao) disp).getCanal());
                    ((Televisao) d).setLigar(((Televisao) disp).isLigar());
                    return (Televisao) d;
                }
        }
        throw new DispositivoNaoEncontradoException(id);
    }

    public static Som verificaSom(Som disp, int id) {
        for (Dispositivo d : bancodeDados) {
            if (d.getId() == id) {
                d.setId(id);
                d.setNome(disp.getNome());
                ((Som) d).setEstacao(((Som) disp).getEstacao());
                ((Som) d).setVolume(((Som) disp).getVolume());
                ((Som) d).setLigar(((Som) disp).isLigar());
                return (Som) d;

            }
        }
        throw new DispositivoNaoEncontradoException(id);
    }

    public static ArCondicionado verificaArcondicionado(ArCondicionado disp, int id) {
        for (Dispositivo d : bancodeDados) {
            if (d.getId() == id) {
                d.setId(id);
                d.setNome(disp.getNome());
                ((ArCondicionado) d).setTemperatura(((ArCondicionado) disp).getTemperatura());
                ((ArCondicionado) d).setModo(((ArCondicionado) disp).getModo());
                return (ArCondicionado) d;
            }
        }
        throw new DispositivoNaoEncontradoException(id);
    }
    public static Portao verificaPortao(Portao disp, int id) {
        for (Dispositivo d : bancodeDados) {
            if (d.getId() == id) {
                d.setNome(disp.getNome());
                d.setId(id);
                ((Portao)d).setAberto(((Portao)disp).isAberto());
                return (Portao) d;
            }
        }
        throw new DispositivoNaoEncontradoException(id);
    }


    public void setDispositivo(Dispositivo disp, int id) {

        this.bancodeDados.set(id,disp) ;
    }



    public void adicionaequip(){
        Lampada lampada = new Lampada(1,"lampada");
        Cortina cortina = new Cortina(2,"cortina");
        Televisao televisao = new Televisao(3,"televisão");
        Som som = new Som(4,"som");
        Portao portao = new Portao(5,"portao");
        ArCondicionado arCondicionado = new ArCondicionado(6,"arcondicionado");
        Lampada lampada2 = new Lampada(7,"lampada");
        Cortina cortina2 = new Cortina(8,"cortina");
        Televisao televisao2 = new Televisao(9,"televisão");
        Som som2 = new Som(10,"som");
        Portao portao2 = new Portao(11,"portao");
        ArCondicionado arCondicionado2 = new ArCondicionado(12,"arcondicionado");
        bancodeDados.add(lampada);
        bancodeDados.add(cortina);
        bancodeDados.add(televisao);
        bancodeDados.add(som);
        bancodeDados.add(portao);
        bancodeDados.add(arCondicionado);
        bancodeDados.add(lampada2);
        bancodeDados.add(cortina2);
        bancodeDados.add(televisao2);
        bancodeDados.add(som2);
        bancodeDados.add(portao2);
        bancodeDados.add(arCondicionado2);
    }
}
