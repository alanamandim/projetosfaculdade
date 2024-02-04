package engtelecom.std.projetofinal.resources;

public class Televisao extends Dispositivo {
    int canal;
    int volume;
    boolean ligar =false;

    public Televisao(int id, String nome) {
        super(id, nome);
    }
    public Televisao(){}

    public void setVolume(int volume) {
        if (volume < 50) {
            this.volume = volume;
        }
    }

    public void setLigar(boolean ligar) {
        this.ligar = ligar;
    }

    public boolean isLigar() {
        return ligar;
    }

    public int getVolume() {
        return volume;
    }

    public void setCanal(int canal) {
        if (canal < 500) {
            this.canal = canal;
        }
    }

    public int getCanal() {
        return canal;
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
