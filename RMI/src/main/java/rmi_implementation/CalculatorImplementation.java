package rmi_implementation;

import rmi_interface.CalculatorInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by nazar on 12/1/16.
 */
public class CalculatorImplementation extends UnicastRemoteObject implements CalculatorInterface {

    public CalculatorImplementation() throws RemoteException {
    }


    public int add(int a, int b) {
        return a+b;
    }

    public int subtract(int a, int b) {
        return a-b;
    }

    public int multiply(int a, int b) {
        return a*b;
    }

    public int divide(int a, int b) {
        return a/b;
    }
}
