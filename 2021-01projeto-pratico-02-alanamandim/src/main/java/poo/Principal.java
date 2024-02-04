package poo;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    //Altere aqui o nome do grafo e o seu label para criação
    private final String nomeGrafo = "Rede";
    private final String grafolabel = "Rede Compartilhada";

    Grafo grafoSerializado;

    public void salvarEmDiscoEmOutroFormato(String nomeArq, Grafo salvarGrafo) {
        File arqIncompleto = new File(nomeArq + ".incompleto");

        try {
            FileOutputStream fout = new FileOutputStream(arqIncompleto);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(salvarGrafo);
            oos.flush(); // limpando dados em buffer
            oos.close(); // fechando fluxo de saida
            fout.close(); // fechando arquivo
        } catch (Exception ex){
            System.err.println("erro: " + ex.toString());
        }
    }

    public Grafo lerDoDisco(String nomeArquivo){

        try {
            FileInputStream fin = new FileInputStream(nomeArquivo + ".incompleto");
            ObjectInputStream oin = new ObjectInputStream(fin);

            grafoSerializado = (Grafo) oin.readObject();
            oin.close(); //fechando fluxo de entrada
            fin.close(); //fechando arquivo
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return grafoSerializado;
    }


    public void  menu(){

        Scanner input = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);
        Grafo grafo = new Grafo(nomeGrafo,grafolabel);
        boolean sair = true;
        while (sair) {
            // Menu com as opções de escolha mostrado em tela
            try {
                System.out.println("\n  Gerador de Diagramas de Redes   ");
                System.out.println("  1. Adicionar Equipamento de rede no grafo");
                System.out.println("  2. Criar o subgrafo/fazer conexões");
                System.out.println("  3. Visualizar diagrama");
                System.out.println("  4. Exportar diagrama .dot");
                System.out.println("  5. Salvar o diagrama atual em formato .incompleto");
                System.out.println("  6. Carregar um diagrama .incompleto");
                System.out.println("  7. Sair da aplicação");
                System.out.print("  Escolha uma das opções -> ");
                int option = input.nextInt();

                // Entrada das opções
                switch (option) {
                    case 1:
                        int opcao = 0;

                        while (opcao >= 8 || opcao <= 0) {
                            System.out.println("Informe qual equipamento deseja adicionar para o grafo");
                            System.out.println("1. Internet");
                            System.out.println("2. Roteador");
                            System.out.println("3. Servidor");
                            System.out.println("4. Firewall");
                            System.out.println("5. Camera Ip");
                            System.out.println("6. Switch");
                            System.out.println("7. Desktop");
                            System.out.print("Escolha uma das opções -> ");
                            opcao = input.nextInt();
                            System.out.println(opcao);
                        }
                        String label;
                        String nome;
                        switch (opcao) {
                            case 1:
                                System.out.println("informe o nome ");
                                nome = inputString.nextLine();

                                No internet = new No(nome, Equipamentos.INTERNET);

                                System.out.println("informe o label ");
                                label = inputString.nextLine();
                                internet.adicionaDados("label", label);
                                internet.adicionaDados("image", Equipamentos.INTERNET.figura);
                                grafo.adicionaNo(internet);

                                break;

                            case 2:
                                System.out.println("Informe o nome");
                                nome = inputString.nextLine();
                                System.out.println("informe o label ");
                                label = inputString.nextLine();
                                int opc2 = 0;
                                while (opc2 <= 0 || opc2 >= 3) {
                                    System.out.println("Informe qual modelo de roteador");
                                    System.out.println(" 1 - Azul");
                                    System.out.println(" 2 - Verde");
                                    opc2 = input.nextInt();
                                    System.out.println(opc2);
                                    switch (opc2) {
                                        case 1:
                                            No router = new No(nome, Equipamentos.ROUTERBLUE);
                                            router.adicionaDados("image", Equipamentos.ROUTERBLUE.figura);
                                            router.adicionaDados("label", label);
                                            grafo.adicionaNo(router);
                                            break;
                                        case 2:
                                            No router1 = new No(nome, Equipamentos.ROUTERGREEN);
                                            router1.adicionaDados("image", Equipamentos.ROUTERGREEN.figura);
                                            router1.adicionaDados("label", label);
                                            grafo.adicionaNo(router1);
                                            break;
                                    }

                                }
                                break;

                            case 3:
                                System.out.println("informe o nome ");
                                nome = inputString.nextLine();
                                No server = new No(nome, Equipamentos.SERVIDOR);
                                System.out.println("informe o label ");
                                label = inputString.nextLine();
                                server.adicionaDados("label", label);
                                server.adicionaDados("image", Equipamentos.INTERNET.figura);
                                grafo.adicionaNo(server);
                                break;

                            case 4:
                                System.out.println("informe o nome ");
                                nome = inputString.nextLine();
                                No firewall = new No(nome, Equipamentos.FIREWALL);
                                System.out.println("informe o label ");
                                label = inputString.nextLine();
                                firewall.adicionaDados("label", label);
                                firewall.adicionaDados("image", Equipamentos.FIREWALL.figura);
                                grafo.adicionaNo(firewall);
                                break;

                            case 5:
                                System.out.println("informe o nome ");
                                nome = inputString.nextLine();
                                No cameraip = new No(nome, Equipamentos.CAMERAIP);
                                System.out.println("informe o label ");
                                label = inputString.nextLine();
                                cameraip.adicionaDados("label", label);
                                cameraip.adicionaDados("image", Equipamentos.CAMERAIP.figura);
                                grafo.adicionaNo(cameraip);
                                break;

                            case 6:
                                System.out.println("informe o nome ");
                                nome = inputString.nextLine();
                                No switch1 = new No(nome, Equipamentos.SWITCH);
                                System.out.println("informe o label ");
                                label = inputString.nextLine();
                                switch1.adicionaDados("label", label);
                                switch1.adicionaDados("image", Equipamentos.SWITCH.figura);
                                grafo.adicionaNo(switch1);
                                break;

                            case 7:
                                System.out.println("informe o nome ");
                                nome = inputString.nextLine();
                                No desktop = new No(nome, Equipamentos.DESKTOP);
                                System.out.println("informe o label ");
                                label = inputString.nextLine();
                                desktop.adicionaDados("label", label);
                                desktop.adicionaDados("image", Equipamentos.DESKTOP.figura);
                                grafo.adicionaNo(desktop);
                                break;


                        }
                        break;
                    case 2:
                        int opc=0;
                            while (opc <= 0 || opc >= 4){
                                System.out.println("\n**Implementando Grafo**");
                                System.out.println("* 1. Criar um sub-grafo");
                                System.out.println("* 2. Fazer conexões de dispositivos");
                                System.out.println("* 3. Remover conexões de dispositivos");
                                System.out.println("* 4. Sair ao menu principal");
                                System.out.print("* Escolha uma das opções -> ");
                                opc = input.nextInt();
                                System.out.println(opc);
                            if(opc ==4) break;
                        }
                            if(opc==1) {
                                System.out.println("informe o nome ");
                                nome = inputString.nextLine();
                                System.out.println("informe o label ");
                                label = inputString.nextLine();
                                Subgrafo subgrafo = new Subgrafo(nome,label);
                                System.out.println("\nLista dos Dispositivos:");
                                System.out.println(grafo.listaNos());
                                try{
                                System.out.println("informe a quantidade q deseja adicionar");
                                int qtd = input.nextInt();
                                for(int i=0; i<qtd;i++) {
                                    System.out.println("\nInforme o dispositivo:");
                                    String name = inputString.nextLine();
                                    if (grafo.verificaNo(name)) {
                                        subgrafo.adicionaDados(name, name);
                                        System.out.println("\n" + name + " adicionado ao subgrafo");
                                    }else{
                                        System.out.println("Dispositivo inexistente");
                                    }

                                }
                                grafo.adicionaSubGrafo(subgrafo);
                                } catch (IndexOutOfBoundsException e){
                                        System.err.println("Erro, valor  inexistente");
                                    } catch (InputMismatchException ex){
                                        System.err.println("Erro, valor fornecido deve ser um número!");
                                    }


                            }
                        if(opc==2){
                            try{
                                //TODO

                                System.out.println("Escolha o dispositivo deseja fazer a ligação:");
                                System.out.println("\nLista dos Dispositivos:");
                                System.out.println(grafo.listaNos());
                                System.out.println("Informe um dispositivo");
                                String inicio = inputString.nextLine();
                               if(grafo.verificaNo(inicio)) {
                                       System.out.println(" Com qual equipamento deseja se conectar?");
                                       String fim = inputString.nextLine();
                                       if (grafo.verificaNo(fim)) {
                                           System.out.println("\nInforme um nome pro arco:");
                                           nome = inputString.nextLine();
                                           Arco a = new Arco(nome, inicio, fim);
                                           if(!grafo.adicionaArco(a)){
                                               System.out.println("\nNão foi possível realizar a conexão");
                                           }else{
                                               System.out.println("Conexão concluída");
                                           };
                                       }

                               }

                            } catch (IndexOutOfBoundsException e){
                                System.err.println("Erro, nome do dispositivo inexistente");
                            } catch (InputMismatchException ex){
                                System.err.println("Erro, nome do dispositivo inexistente");
                            }
                        }
                        if(opc==3){
                            //TODO
                            System.out.println("Informe o nome do arco que deseja remover");
                            System.out.println(grafo.listaArcos());
                            String arco = inputString.nextLine();
                            if(grafo.deletaArco(arco)){
                                System.out.println("\nArco :" +arco+ " removido");
                                System.out.println(grafo.listaArcos());
                            }else {
                                System.out.println("\n O arco informado não existe");
                            }
                        }
                        break;
                    case 3:
                        System.out.println("** O diagrama está desta forma: **\n");
                        System.out.println(grafo.diagrama());
                        break;

                    case 4:
                        if(grafo.verificaConexao()){
                            System.out.println("Com qual nome deseja exportar em arquivo:");
                            String nomeArquivo = inputString.nextLine();

                            grafo.salvarEmDisco(nomeArquivo);
                            System.out.println("Arquivo salvo");
                        } else System.out.println("Realize as devidas conexões");

                        break;
                    case 5:
                        System.out.println("**Salvar atual diagrama**");
                        System.out.println(grafo.diagrama());
                        System.out.println("\nSalvando por aqui é possível continuar de onde parou...\n");
                        System.out.println("Com qual nome deseja salvar em arquivo:");
                        String nomeArqIncompleto = inputString.nextLine();

                        salvarEmDiscoEmOutroFormato(nomeArqIncompleto, grafo);
                        System.out.println("Arquivo salvo");
                        break;
                    case 6:
                        System.out.println("**Carregar diagrama**");
                        System.out.println("Continuar de onde parou... \n");
                        System.out.println("Qual o nome do arquivo .incompleto: ");
                        String arq = inputString.nextLine();

                        grafo = lerDoDisco(arq);

                        break;



                    case 7:
                        sair = false;
                        break;
                    default:
                        System.out.println("** Opção Inválida **");
                        break;
                }
            } catch (java.util.InputMismatchException e) {
                System.err.println("Erro: Valor não inteiro!\n");
                input.nextLine();
            }
        }
    }
    public static void main(String[] args) {
        Principal p = new Principal();

        p.menu();


    }
}



