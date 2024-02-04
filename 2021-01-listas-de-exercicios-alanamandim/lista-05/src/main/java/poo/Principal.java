package poo;

import java.util.ArrayList;

/**
 * classe poo.Principal
 * execução
 */
public class Principal {
    public static void main(String[] args) {
        ArrayList<Veiculo>veiculos = new ArrayList<>();

        Ferrari ferrari = new Ferrari("top");
        Pampa pampa = new Pampa("medio");
        Panther panther = new Panther("bolado");

        /**
         * Adiciona instancias ao array de veiculos
         * */
        veiculos.add(ferrari);
        veiculos.add(pampa);
        veiculos.add(panther);

        /**
         *  poo.Ferrari funcões
         */

        ferrari.acelerar(200);

        /**
         * Frear
         */
        ferrari.frear(182);

        /**
         * liga farol
         */
        if(ferrari.ligarFarolNeblina()){
            System.out.println("Farol de neblina ligado!");
        }

        /**
         * Abre capota
         */
        ferrari.abrirCapota();
        System.out.println("Capota aberta");

        /**poo.Pampa funcoes
         * acelerar
         */
        pampa.acelerar(50);

        /**
         * frear
         */
        pampa.frear(50);

        /**
         * abrir caçamba
         */
        pampa.abrirCacamba();
        System.out.println("Abrindo caçamba");

        /**
         * Ativa tração
         */
        pampa.ativarDesativarTracao();
            System.out.println("Tração ativada!");

        /**
         * Desativa tração
         */
        pampa.ativarDesativarTracao();
        System.out.println("Tração desativada!");

        /**
         * Funções panther
         * acelera
         */
        panther.acelerar(20);

        /**
         * freia
         */
        panther.frear(20);

        /**
         * recolhe rodas
         */
        panther.recolherRodas();
        System.out.println("Rodas recolhidas");

        /**
         * abre rodas
         */
        panther.abrirRodas();
        System.out.println("Rodas abertas!");

        /**
         * altera temp
         */
        panther.setTempRefri(30);


        /**
         * Ativa tração
         */
        panther.ativarDesativarTracao();
        System.out.println("Tração ativada!");






    }
}
