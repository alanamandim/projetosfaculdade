package poo;

import java.util.ArrayList;

public class Agenda {

        private ArrayList<Pessoa> contatos;

        public Agenda(){
            this.contatos = new ArrayList<>();
        }

        public void adicionaPessoa(Pessoa pessoa){
            this.contatos.add(pessoa);
        }

        public boolean adicionaTel(int posPessoa,String tipo, String numero){
            return this.contatos.get(posPessoa).adicionaTel(tipo,numero);
        }



}
