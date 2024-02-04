package engtelecom.std.projetofinal.resources;

public class ArCondicionado extends Dispositivo {
    int modo;
    int temperatura;
    boolean ligar = false;

    public ArCondicionado(int id,String nome) {
        super(id, nome);
    }
    public ArCondicionado(){}

    public int getModo() {
        return modo;
    }

    public void setModo(int modo) {
        if (modo < 4) {
            this.modo = modo;
        }
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
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
