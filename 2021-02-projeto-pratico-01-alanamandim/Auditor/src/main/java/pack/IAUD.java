package pack;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAUD extends Remote {
    int logar() throws RemoteException;
    boolean jogar() throws RemoteException;
    boolean terminar() throws RemoteException;
    boolean verificamovimento(int id, String mov) throws RemoteException;
    boolean bandeiraCapturada(double x, double y, int id) throws RemoteException;
    int getvez() throws RemoteException;
    void setvez(int vez) throws RemoteException;
    double getX(int id) throws RemoteException;
    double getY(int id) throws RemoteException;
    //  int getBandeira() throws RemoteException;
    void informacaptura(int id)throws RemoteException;
    int  verificacapt() throws RemoteException;
    void setidcapt()throws RemoteException;
    String informavencedor() throws RemoteException;
    double getBandeirasX(int var1) throws RemoteException;
    double getBandeirasY(int var1) throws RemoteException;
    void reinicia() throws RemoteException, InterruptedException;
}
