package engtelecom.std.projetofinal.resources;

public class Som extends Dispositivo {
    int volume;
    int estacao;
    boolean ligar =false;

    public Som(int id,String nome) {
        super(id, nome);
    }
    public Som(){}

    public int getEstacao() {
        return estacao;
    }

    public void setEstacao(int estacao) {
        this.estacao = estacao;
    }

    public void setLigar(boolean ligar) {
        this.ligar = ligar;
    }

    public boolean isLigar() {
        return ligar;
    }

    public void setVolume(int volume) {
        if (volume < 50) {
            this.volume = volume;
        }
    }

    public int getVolume() {
        return volume;
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
