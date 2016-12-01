package rmi_client;

import rmi_interface.CalculatorInterface;
import rmi_interface.StringInterface;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by nazar on 12/1/16.
 */
public class CalcClient {

    public static void main(String[] args){
        try {
            Registry myReg = LocateRegistry.getRegistry("127.0.0.1", 10999);

            CalculatorInterface c = (CalculatorInterface)myReg.lookup("mycalc");

            System.out.println("1+2="+c.add(1,2));
            System.out.println("5-2="+c.subtract(5,2));
            System.out.println("2*2="+c.multiply(2,2));
            System.out.println("100/5="+c.divide(100,5));

            Registry myReg1 = LocateRegistry.getRegistry("127.0.0.1", 1099);
            StringInterface s = (StringInterface)myReg1.lookup("mystring");

            System.out.println("size of string 'nazar' is "+s.getLength("nazar"));

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
