
package pack;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IMON extends Remote {
    double getBandeirasX(int var1) throws RemoteException;

    double getBandeirasY(int var1) throws RemoteException;

    boolean bandeiraCapturada(int var1) throws RemoteException;

    double getX(int id) throws RemoteException;

    double getY(int id) throws RemoteException;

    //  int getid() throws RemoteException;

    int getdiimensao() throws RemoteException;
    int getmov()throws RemoteException;


    boolean terminar()throws RemoteException;
}


