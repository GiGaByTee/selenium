package rmi_server2;

import rmi_implementation.CalculatorImplementation;
import rmi_implementation.StringImpl;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by nazar on 12/1/16.
 */
public class LengthServer {

    public static void main(String[] args){
        try{
            Registry reg = LocateRegistry.createRegistry(1099);
            StringImpl c = new StringImpl();
            reg.bind("mystring", c);

            System.out.println("Server2 is ready ...");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
