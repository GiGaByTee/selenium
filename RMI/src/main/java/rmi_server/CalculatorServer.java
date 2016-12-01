package rmi_server;

import rmi_implementation.CalculatorImplementation;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by nazar on 12/1/16.
 */
public class CalculatorServer {

    public static void main(String[] args){
        try{
            Registry reg = LocateRegistry.createRegistry(10999);
            CalculatorImplementation c = new CalculatorImplementation();
            reg.bind("mycalc", c);

            System.out.println("Server is ready ...");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
