package engtelecom.std.projetofinal.resources;

public class Lampada extends Dispositivo {
    int luminosidade;
    boolean ligar = false;
    public Lampada(){}

    public Lampada(int id, String nome){super(id,nome);}

    public void setLigar(boolean ligar) {
        this.ligar = ligar;
    }

    public boolean isLigar() {
        return ligar;
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setNome(String nome) {
        super.setNome(nome);
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    public int getLuminosidade() {
        return luminosidade;
    }

    public void setLuminosidade(int luminosidade) {
        this.luminosidade = luminosidade;
    }
}
