package engtelecom.std.projetofinal.resources;

public class Portao extends Dispositivo {
    boolean aberto=false;

    public Portao(int id, String nome) {
        super(id, nome);
    }
    public Portao(){}

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    public boolean isAberto() {
        return aberto;
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public int getId() {
        return super.getId();
    }
}
