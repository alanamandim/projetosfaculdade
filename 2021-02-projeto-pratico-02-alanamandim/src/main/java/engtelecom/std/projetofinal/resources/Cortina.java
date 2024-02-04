package engtelecom.std.projetofinal.resources;

public class Cortina extends Dispositivo {
    boolean aberta;
    public Cortina(){}

    public Cortina(int id, String nome) {
        super(id, nome);
    }

    public void setAberta(boolean aberta) {
        this.aberta = aberta;
    }

    public boolean getAberta() {
        return aberta;
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
