package jogador;

import pack.IAUD;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class Jogador {

    private static String nomeServidor = "auditor";
    private static int porta = 12345;
    private static String OBJNAME = "JogoBandeira";
    private int id;
    private String[] mov;

    public void bandeira(IAUD stub) throws RemoteException {
        if (id != stub.verificacapt() && stub.verificacapt() != 0) {
            System.out.println("O jogador " + stub.verificacapt() + " capturou a bandeira");
            stub.setidcapt();
        }
    }

    public boolean acompanhajogo(IAUD stub) throws RemoteException, InterruptedException {
        boolean roda = true;
        //  System.out.println("O robo 1"  + " está na casa " + (stub.getX(1) + 1) + " ,, " + (stub.getY(1) + 1));
        //  System.out.println("O robo 2 está na casa "+ (stub.getX(2)+1) +" ,,, "+(stub.getY(2)+1));
        int j = 0;
        while (roda) {
            // int aux=0;
            // if (stub.logar() == id) {
            // if (stub.verificamovimento(id, movimentos.get(j))) {
            if(stub.getvez()==id){
                if (stub.verificamovimento(id, mov[j])) {
                    j++;
                    if(id==1 && j>1) {
                        System.out.println("O player 2 se movimentou para casa ( " + (stub.getX(2) + 1) + " ,* " + (stub.getY(2) + 1) + " )");
                        System.out.println("Está na vez do jogador "+id);
                        bandeira(stub);
                    }
                    if(j>0 &&id==2){
                        System.out.println("O player 1 se movimentou para casa ( " + (stub.getX(1) + 1) + " ,+ " + (stub.getY(1) + 1)+" )");
                        System.out.println("Está na vez do jogador "+id);
                        bandeira(stub);


                    }
                    System.out.println("O player " + id + " se movimentou para casa ( " + (stub.getX(id) + 1) + " , " + (stub.getY(id) + 1)+" )");
                    if (stub.bandeiraCapturada(stub.getX(id), stub.getY(id), id)) {
                        stub.informacaptura(id);
                        // aux++;
                        System.out.println("O jogador " + id + " capturou a bandeira");

                    }
                    if(id==1) {
                        System.out.println("Está na vez do jogador 2");
                        stub.setvez(2);
                    }else {
                        System.out.println("Está na vez do jogador 1");
                        stub.setvez(1);
                    }

                /*if(id!=stub.verificacapt() && stub.verificacapt()!=0){
                    System.out.println("O jogador "+ stub.verificacapt()+ "capturou a bandeira");
                    stub.setidcapt();*/

                }else{
                    System.out.println("Movimento Inválido");
                    j++;
            /*    if (id == 1) {
                    stub.setvez(2);
                    System.out.println("Está na vez do jogador 2 ");

                } else {
                    stub.setvez(1);
                    System.out.println("Está na vez do jogador 1 ");

                }*/

                } //else {
            }
            // ++j;
            //System.out.println("Movimento inválido");

            TimeUnit.SECONDS.sleep(2);
            //}

            roda = stub.terminar();
        }
        System.out.println(stub.informavencedor());
        return true;

    }


    public void jogar(String args) {
        try {
            System.out.println("Conectando no servidor : " + nomeServidor);
            Registry registro = LocateRegistry.getRegistry(nomeServidor, porta);
            IAUD stub = (IAUD) registro.lookup(OBJNAME);
            id = stub.logar();
            System.out.println("O  seu robo "  + " está na casa " + (stub.getX(id) + 1) + " ,, " + (stub.getY(id) + 1));
            //  System.out.println("O robo 2 está na casa "+ (stub.getX(2)+1) +" ,,, "+(stub.getY(2)+1));
            for(int i=1;i<4;i++) {
                System.out.println("A bandeiras "+i+ "está na coordenada ( "+ stub.getBandeirasX(i)+ " , "+ stub.getBandeirasY(i)+" )");
            }
            boolean loop = true;

            if (args != null) {
                String nomearquivo = args;
                //criar função para separar os movimentos
                // String[] dados = linhadecomando.split(" ");*/

             /*   System.out.println("Conectando no servidor : " + nomeServidor);
                Registry registro = LocateRegistry.getRegistry(nomeServidor, porta);
                IAUD stub = (IAUD) registro.lookup(OBJNAME);
                boolean loop = true;
                id = stub.logar();*/

                while (loop) {
                    //informa id do usuário
                    // this.id = stub.logar();
                    //verifica se já tem dois jogadores
                    if (stub.jogar()) {
                        //   movimentos = new ArrayList<>();

                        try (BufferedReader br = new BufferedReader(new FileReader("./src/main/resources/" + nomearquivo))) {
                            String line;
                            // String [] dados;

                            while ((line = br.readLine()) != null) {
                                String[] dados = line.split(" ");
                                mov = dados;
                                //  movimentos.add(String.valueOf(line.split(" ")));
                            }
                            if(acompanhajogo(stub)){
                                stub.reinicia();
                                loop=false;
                            };





                             /*   for (int i = 0; i < movimentos.size(); i++) {
                                    if (!stub.verificamovimento(id, String.valueOf(movimentos.get(i))) && stub.esperavez() == id) {
                                        System.out.printf("Movimento Inválido");
                                    }
                                }*/

                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (AccessException ex) {
            ex.printStackTrace();
        } catch (NotBoundException ex) {
            ex.printStackTrace();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }
      /*  boolean loop = true;

            if (args != null) {
                String nomearquivo = args;
                //criar função para separar os movimentos
                // String[] dados = linhadecomando.split(" ");*/

             /*   System.out.println("Conectando no servidor : " + nomeServidor);
                Registry registro = LocateRegistry.getRegistry(nomeServidor, porta);
                IAUD stub = (IAUD) registro.lookup(OBJNAME);
                boolean loop = true;
                id = stub.logar();*/

  /*              while (loop) {
                    //informa id do usuário
                    // this.id = stub.logar();
                    //verifica se já tem dois jogadores
                    if (stub.jogar()) {
                     //   movimentos = new ArrayList<>();

                        try (BufferedReader br = new BufferedReader(new FileReader("./src/main/resources/" + nomearquivo))) {
                            String line;
                            // String [] dados;

                            while ((line = br.readLine()) != null) {
                              String [] dados = line.split(" ");
                              mov=dados;
                                //  movimentos.add(String.valueOf(line.split(" ")));
                            }
                            acompanhajogo(stub);



                             /*   for (int i = 0; i < movimentos.size(); i++) {
                                    if (!stub.verificamovimento(id, String.valueOf(movimentos.get(i))) && stub.esperavez() == id) {
                                        System.out.printf("Movimento Inválido");
                                    }
                                }*/


            /*            } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }


                    }
                }

            }


        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
*/

    public static void main(String[] args) {
        Jogador jogador = new Jogador();
        jogador.jogar(args[0]);
    }
}
