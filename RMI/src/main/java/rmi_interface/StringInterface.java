package rmi_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by nazar on 12/1/16.
 */
public interface StringInterface extends Remote {
    public int getLength(String s) throws RemoteException;
}
