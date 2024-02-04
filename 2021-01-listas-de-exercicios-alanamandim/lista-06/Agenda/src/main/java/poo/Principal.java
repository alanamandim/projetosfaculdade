package poo;

import poo.Agenda;
import poo.Pessoa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;


public class Principal {
    private Agenda agenda;
    ArrayList<Pessoa> pessoas = new ArrayList<>();

    public Principal() {

        this.agenda = new Agenda();
    }

    public void adicionaPessoa(String nome, String sobrenome, int ano, int mes, int dia) {

        pessoas.add(new Pessoa(nome, sobrenome, LocalDate.of(ano, mes, dia)));

    }
    public void adicionaTelefone(int id,String tipo, String numero) {

        pessoas.get(id).adicionaTel("celular", "21996939600");
    }
    public void adicionaEmail(int id, String tipo, String email) {
        pessoas.get(id).adicionaEmail(tipo, email);
    }
    public void adicionaPessAgenda(int id) {
        this.agenda.adicionaPessoa(pessoas.get(id));

    }
    public  void adicionaTelefoneAgenda(int id, String tipo, String numero) {

        this.agenda.adicionaTel(id, tipo, numero);
    }

    public void printListasemMod() {
        System.out.println("Lista sem modificação");

        System.out.println(pessoas);
    }

    public void printaListaMod(){
        // Ordena a lista de pessoas, invocando o método compareTo,
        // implementada na classe Pessoa
        Collections.sort(pessoas);

        // Imprimindo em tela a lista de pessoas ordenada
        System.out.println("Lista ordenada");
        System.out.println(pessoas);

    }

    public static void main(String[] args) {

        Principal p = new Principal();

        //Adiciona pessoas
        p.adicionaPessoa("Alana", "Mandim", 1994, 5, 10);
        p.adicionaPessoa("Ana", "Paula", 1989, 1, 1);
        p.adicionaPessoa("Joao", "Santos",1991, 1, 1);
        p.adicionaPessoa("José", "Santos", 1980, 1, 1);
        p.adicionaPessoa("Aline", "Fernandes", 2001, 11, 8);
        p.adicionaPessoa("Armando", "Nandes",2002,06,1);
        p.adicionaPessoa("José", "Silva", 1990, 1, 1);

        //Adiciona Telefone informando o id da pessoa
        p.adicionaTelefone(0,"celular", "21996939600");
        p.adicionaTelefone(0,"casa", "2125957382");

        //Adiciona Email informando o id da pessoa
        p.adicionaEmail(0,"pessoal", "alanamandim94@gmail.com");
        p.adicionaEmail(0,"comercial", "alana.brm@ifsc.edu.br");

        //Adiciona a Pessoa na Agenda informando id da pessoa
        p.adicionaPessAgenda(0);

        //Adiciona telefone na agenda informando o id da pessoa, tipo e o numero
        p.adicionaTelefoneAgenda(0, "celular","21985458545");

        //Printa a lista sem modificação
        p.printListasemMod();

        //Printa lista com modificação
        p.printaListaMod();


    }
}
