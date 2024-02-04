package monitorgui;
import edu.princeton.cs.algs4.Draw;
import pack.IMON;

import java.awt.*;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.concurrent.TimeUnit;

public class Monitor{
    private static String serverName = "127.0.0.1"; //"localhost";
    private static int port = 12345;
    private static final String OBJNAME = "JogoBandeira";
    private static Draw draw;

    public static void desenhaTabuleiro(int dimensao, Draw draw){
       // draw = new Draw();
        draw.setXscale(0,dimensao);
        draw.setYscale(0,dimensao);
        draw.enableDoubleBuffering();
        desenharTela(dimensao,draw);

    }

    public static void desenharTela(int dimensao, Draw draw){
        draw.clear(Color.LIGHT_GRAY);
        draw.setPenColor(Color.black);
        for (int i = 0; i <= dimensao; i++) draw.line(i, 0, i, dimensao);
        for (int j = 0; j <= dimensao; j++) draw.line(0, j, dimensao, j);

    }




    public static void desenharPecas(IMON stub) throws RemoteException, InterruptedException {


        //if (stub.getid() == 1) {
            draw.picture(stub.getX(1)+0.5, stub.getY(1)+0.5, Pecas.ROBO.figura);
        //} else {
            draw.picture(stub.getX(2)+0.5, stub.getY(2)+0.5, Pecas.ROBO1.figura);
      //  }

        for (int i = 1; i < 4; i++) {
            if (!stub.bandeiraCapturada(i)) {
                draw.picture(stub.getBandeirasX(i)+0.5, stub.getBandeirasY(i)+0.5, Pecas.BANDEIRA1.figura);
            }
        }
    }



        public static void main(String[] args){
        try{
            System.out.println("Conectando em: "+serverName);
            Registry registro = LocateRegistry.getRegistry(serverName,port);
            draw = new Draw();
            IMON stub = (IMON) registro.lookup(OBJNAME);
            desenhaTabuleiro(stub.getdiimensao(),draw);
            int x= stub.getmov();
            boolean roda= true;

           // DesenhaTela desenhaTela = new DesenhaTela(stub.getdiimensao());
            while (roda) {

                // desenhaTabuleiro(stub.getdiimensao());
              //  desenharPecas(stub);

               // if(x==stub.getmov()) {
                  //  desenhaTabuleiro(stub.getdiimensao());
                    if(x>1){
                        draw.clear();
                        desenhaTabuleiro(stub.getdiimensao(), draw);
                    }
                    desenharPecas(stub);
                    draw.show();
                    x++;

               // }
              //  TimeUnit.SECONDS.sleep(3);
                roda=stub.terminar();
            }
            System.out.println(stub.vencedor());







        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
