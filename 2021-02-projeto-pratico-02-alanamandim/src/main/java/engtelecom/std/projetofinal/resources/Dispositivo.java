package engtelecom.std.projetofinal.resources;

public abstract class Dispositivo {
    int id;
    String nome;

    public Dispositivo(int id, String nome) {
        this.id =id;
        this.nome = nome;
    }
    public Dispositivo(){}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

}
