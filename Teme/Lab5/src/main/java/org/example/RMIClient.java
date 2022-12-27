package org.example;

import java.rmi.Naming;

public class RMIClient {
    static int rez = 0;
    static Adunare adunare = null;

    public static void main(String args[]) {

        try {
            int a[] = {1, 2, 3};
            adunare = (Adunare) Naming.lookup("//" + "localhost" + "/add");
            rez = adunare.addNumbers(a);
            System.out.println("rezultatul adunarii vectorilor folosind RMI: " + rez);
        } catch (Exception e) {
            System.out.println("eroarea zice: " + e.getMessage());
        }
    }

}
