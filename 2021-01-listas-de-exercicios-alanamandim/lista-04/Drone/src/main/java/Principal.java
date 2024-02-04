import java.util.Scanner;

public class Principal {

    public void menu(){
        Drone drone = new Drone(new Camera(),new Gps(20,20,0), new Rotores());

        Scanner dados = new Scanner(System.in);
        Scanner dadosString = new Scanner(System.in);
        boolean loop=true;

        while (loop){
            try{
            System.out.println( " Escolha uma das opções");
            System.out.println(" 1 - Decolar");
            System.out.println(" 2 - Alterar Altitude");
            System.out.println(" 3 - Mover para uma direção");
            System.out.println(" 4 - Posição Atual");
            System.out.println(" 5 - Verificar bateria");
            System.out.println( "6 - Retornar para posição Inicial");
            System.out.println( " 7 - Tirar foto ou gravar vídeo");
            System.out.println(" 8- Informar plano de voo para iniciação de voo autônomo");
            System.out.println(" 9 - Sair da aplicação");

            int escolha = dados.nextInt();

            switch (escolha) {

                case 1:
                    System.out.println("Bateria: " + drone.getBateria());
                    System.out.println(drone.localAtual());
                    if (drone.decolagem()) {
                        System.out.println("O drone está com os motores ligados aguardando novas instruções ");
                        System.out.println(drone);

                    } else {
                        System.out.println("Não foi possível decolar o drone");
                    }
                    break;


                case 2:
                    System.out.println("Bateria: " + drone.getBateria());
                    System.out.println(drone.localAtual());
                    System.out.println(" Escolha a opção abaixo");
                    System.out.println(" 1- Sobe");
                    System.out.println(" 2- Desce");
                    int op = dados.nextInt();
                    System.out.println("Informe um valor  para alterar a altitude");
                    double desl = dados.nextDouble();
                    if(op==2) {
                        if (!drone.verficor(desl)) {
                            System.out.println("Movimento não permitido devido a altitude");
                            break;
                        }
                    }
                    if (drone.alterarAltiitude(op, desl)) {
                            System.out.println(drone.localAtual());
                            System.out.println(drone);

                    } else {
                            System.out.println("Bateria abaixo de 5 retornando para o ponto inicial");
                            drone.retorno();

                    }

                    break;

                case 3:
                    System.out.println("Bateria: " + drone.getBateria());
                    System.out.println(drone.localAtual());
                    System.out.println("Escolha uma das opções");
                    System.out.println(" 1 - Direita");
                    System.out.println(" 2 - Esquerda");
                    System.out.println(" 3 - Frente");
                    System.out.println(" 4 - Trás");
                    int opc = dados.nextInt();
                    System.out.println("Informe um valor  para se movimentar");
                    double mov = dados.nextDouble();
                    if (drone.movDrone(opc, mov)) {
                        System.out.println("O drone se movimentou");
                        System.out.println(drone.localAtual());
                        System.out.println(drone);
                    } else {
                        System.out.println("Bateria abaixo de 5 retornando para o ponto inicial");
                        drone.retorno();
                    }
                    break;
                case 4:
                    System.out.println(drone.localAtual());
                    break;
                case 5:
                    System.out.println("Bateria: " + drone.getBateria());
                    break;
                case 6:
                    System.out.println("Bateria: " + drone.getBateria());
                    System.out.println(drone.localAtual());
                    if (drone.retorno()) {
                        System.out.println(drone.localAtual());
                        System.out.println(drone);

                    } else {
                        System.out.println("Não foi possível retornar");

                    }
                    break;
                case 7:
                    System.out.println("Bateria: " + drone.getBateria());
                    System.out.println(" 1- Tirar foto");
                    System.out.println(" 2- Gravar vídeo");
                    int opt = dados.nextInt();
                    if(drone.getBateria()<5){
                        System.out.println("Bateria abaixo de 5 retornando para o ponto inicial");
                        drone.retorno();
                    }else {
                        if (opt == 1) {
                            System.out.println("Salvar foto como ");
                            String nFoto = dadosString.nextLine();
                            String foto = drone.tiraFoto(nFoto);
                            System.out.println(foto);
                            System.out.println(drone);
                        }

                        if (opt == 2) {
                            System.out.println("Salvar vídeo como ");
                            String nVideo = dadosString.nextLine();
                            String video = drone.gravaVideo(nVideo);
                            System.out.println(video);
                            System.out.println(drone);
                        }
                        if (opt == 0 || opt > 2) {
                            System.out.println("Opção inválida");
                        }
                    }
                    break;

                case 8:
                    System.out.println("Bateria: " + drone.getBateria());
                    System.out.println(drone.localAtual());
                    System.out.println("informe a quantidade de movimentos");
                    int loop2 = dados.nextInt();
                    String linha= " ";

                   for(int i=0;i<loop2;i++) {
                       System.out.println("Digite os movimentos no seguinte modelo:" + "\n" +
                               "numero de do deslocamento , movimento sendo eles ( Frente, Atrás, Cima, Baixo, Direita ou Esquerda");
                       linha += dadosString.nextLine() + ",";
                   }
                   String[] stringSeparada = linha.split(",");
                   drone.planoVoo(stringSeparada);
                   System.out.println(drone.localAtual());
                   System.out.println(drone);
                   break;

                case 9:
                    loop = false;
                    break;
            }
            } catch (java.util.InputMismatchException e) {
                System.err.println("Erro: Valor não inteiro! ");
                loop = false;
            }
        }
    }

    public static void main(String[] args) {
        Principal p = new Principal();

        p.menu();
    }

}




