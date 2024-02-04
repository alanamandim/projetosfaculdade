package auditor;

import pack.IAUD;
import pack.IMON;


import java.rmi.AlreadyBoundException;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Auditor {
    private static String nomeServidor ="127.0.0.1"; //"localhost";
    private static int porta = 12345;
    private static String OBJNAME = "JogoBandeira";

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        boolean roda= true;
        try{
            Jogo jogo = new Jogo();
            System.setProperty("jama.rmi.server.hostname",nomeServidor);
           // IMON stub1 = (IMON) UnicastRemoteObject.exportObject(jogo,2500);
            IAUD stub = (IAUD) UnicastRemoteObject.exportObject(jogo,2500);
            Registry registry = LocateRegistry.createRegistry(porta);
          //  registry.bind("JogoBandeiraMonitor",stub1);
            registry.bind(OBJNAME,stub);
            System.out.println("Servidor pronto!\n");
            System.out.println("Pressione CTRL + C para encerrar...");

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }


    }
}