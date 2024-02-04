package poo;

import java.time.LocalDate;

public class Pessoa implements Comparable<Pessoa>{
    private String nome;
    private String ultimoNome;
    private LocalDate dataNascimento;
    private Email emails;
    private Telefone telefones;

    public Pessoa(String nome, String sobrenome, LocalDate dataNascimento){
        this.nome = nome;
        this.ultimoNome = sobrenome;
        this.emails = new Email();
        this.dataNascimento = dataNascimento;
        this. telefones = new Telefone();

    }
    public boolean adicionaTel(String tipo, String numero) {
        return this.telefones.adiciona(tipo,numero);
    }

    public boolean deleta(String tipo){
        return this.telefones.deleta(tipo);
    }

    public boolean modificaTel(String tipo, String numero){
        return this.telefones.modifica(tipo,numero);
    }

    public boolean adicionaEmail(String tipo, String email){
        return this.emails.adiciona(tipo,email);
    }

    public boolean deletaEmail(String tipo){
        return this.emails.deleta(tipo);
    }

    public boolean modificaEmail(String tipo, String email){
        return this.emails.modificacao(tipo, email);
    }

    @Override
    public String toString(){
        StringBuilder texto = new StringBuilder();

        texto.append(nome+", "+ ultimoNome+", "+ dataNascimento+ "\n");
        return texto.toString();
    }




    @Override
    public int compareTo (Pessoa pessoa) {
        int name = this.nome.compareTo (pessoa.nome);
        if (name == 0) {
            int aux = this.ultimoNome.compareTo (pessoa.ultimoNome);
            return aux == 0? this.dataNascimento.compareTo (pessoa.dataNascimento): aux;
        } return name;
    }
}



