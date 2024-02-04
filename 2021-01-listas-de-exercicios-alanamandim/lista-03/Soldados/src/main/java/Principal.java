import java.util.Scanner;

public class Principal {

    public void menu() {
        int opcao;
        int i=0;
        boolean loop = true;
        Scanner info = new Scanner(System.in);
        Soldado[] tropa = new Soldado[10];
        while (loop) {
            try {
                System.out.println("Escolha uma das opções abaixo: ");
                System.out.println(" 1- Criar Soldado");
                System.out.println(" 2- Ver tropa");
                System.out.println(" 3- Movimentar Soldado(s)");
                System.out.println(" 4- Atacar ");
                System.out.println(" 5- Sair");
                opcao = info.nextInt();

                switch (opcao) {
                    case 1:
                        if (Soldado.getQtdTropa() < 10) {
                            System.out.println("Informe um nome para o  Soldado");
                            info.nextLine();
                            String nome = info.nextLine();
                            Soldado soldado = new Soldado(nome);
                            tropa[i] = soldado;
                            i++;
                            System.out.println("O soldado " + nome+" foi adicionado à tropa");
                        } else {
                            System.out.println("Não foi possível adicionar soldado, capacidade máxima já alcançada");
                        }
                        break;
                    case 2:
                        System.out.println(" A tropa contém : " + Soldado.getQtdTropa() + " soldados");
                        for(int j=0;j<i;j++){
                            System.out.print( tropa[j].getNome()+ "  ");

                        }
                        System.out.println(" ");
                        break;
                    case 3:
                        System.out.println("Escolha as opções:");
                        System.out.println(" 1 - Movimentar um soldado");
                        System.out.println(" 2- Movimentar a tropa");
                        info.nextLine();
                        int sub = info.nextInt();
                        switch (sub) {

                            case 1:
                                int mov;
                                System.out.println("Informe o nome do soldado q deseja movimentar");
                                info.nextLine();
                                String nome = info.nextLine();
                                System.out.println("informe quantos passos deseja");
                                mov = info.nextInt();
                                for (int j = 0; j < i; j++) {
                                    if (nome.equals(tropa[j].getNome())) {
                                        tropa[j].movimentar(mov);
                                        System.out.println(" O Soldado " + tropa[j].getNome() + " se movimentou");
                                    }
                                }
                                break;
                            case 2:
                                int move;
                                System.out.println("informe quantos passos deseja");
                                move = info.nextInt();
                                for (int j = 0; j < Soldado.getQtdTropa(); j++) {
                                    tropa[j].movimentar(move);
                                    System.out.println(" O Soldado " + tropa[j].getNome() + " se movimentou e está a uma distância de " + tropa[j].getDist() + " passos");
                                }
                                System.out.println("Toda a tropa se movimentou");
                                break;


                        }
                        break;
                    case 4:
                        if (Soldado.getQtdTropa() == 0) {
                            System.out.println("Nenhum soldado foi criado, impossível atacar!");
                            break;
                        }
                        if (Soldado.getQtdTropa() <= 3) {
                            System.out.println("Ainda não podemos atacar temos só " + Soldado.getQtdTropa() + " soldados");
                            break;
                        } else {
                            info.nextLine();
                            for (int j = 0; j < Soldado.getQtdTropa(); j++) {
                                System.out.println("Escolha a arma para soldado " + tropa[j].getNome() + ": ");
                                System.out.println("");
                                System.out.println(" Fuzil ");
                                System.out.println(" Baioneta ");
                                System.out.println(" Punho ");
                                if(i == 0) {
                                    info.nextLine();
                                }
                                String arma;
                                arma = info.nextLine();;

                                if (arma.isEmpty()) {
                                    tropa[j].atacar();
                                    System.out.println("Soldado " + tropa[j].getNome() + " atacando com: " + tropa[j].getArmPadrao());
                                    continue;
                                }
                                if (tropa[j].atacar(arma)) {
                                    System.out.println("Soldado " + tropa[j].getNome() + " atacando com: " + tropa[j].getArmSoldado());
                                }

                            }
                            break;
                        }
                    case 6:
                        loop = false;
                        break;
                    default:
                        System.out.println("** Opção Inválida **");
                        break;
                }

            } catch (java.util.InputMismatchException e) {
                System.err.println("Erro: Valor não inteiro! ");
                loop = false;
            } catch (Exception e) {
                System.err.println("Ocorreu o erro: " + e.toString());
            }
        }
    }
    public static void main(String[] args) {
        Principal p = new Principal();

        p.menu();
    }

}
