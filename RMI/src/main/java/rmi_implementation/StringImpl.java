package rmi_implementation;

import rmi_interface.StringInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by nazar on 12/1/16.
 */
public class StringImpl extends UnicastRemoteObject implements StringInterface {

    public StringImpl() throws RemoteException{

    }

    public int getLength(String s) throws RemoteException {
        return s.length();
    }
}
