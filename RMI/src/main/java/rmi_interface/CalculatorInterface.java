package rmi_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by nazar on 12/1/16.
 */
public interface CalculatorInterface extends Remote {

    public int add(int a, int b) throws RemoteException;

    public int subtract(int a, int b) throws RemoteException ;

    public int multiply(int a, int b) throws RemoteException;

    public int divide(int a, int b) throws RemoteException;
}
