package org.example;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer extends UnicastRemoteObject implements Adunare {


    protected RMIServer() throws RemoteException {
        super(0);

    }

    public int addNumbers(int[] a) {
        System.out.println("am apelat metoda cu succes!");
        int rez = 0;
        for (int i = 0; i < a.length; i++) {
            rez += a[i];
        }
        return rez;
    }

    public static void main(String args[]) throws Exception {
        System.setProperty("java.rmi.server.hostname", "localhost");
        System.out.println("a pornit serverul...cred");
        try {
            int port = 1099;
            LocateRegistry.createRegistry(port);
            System.out.println("Am reperat RMI de pe " + port);
        } catch (Exception e) {
            System.out.println("eroarea de la sserver: " + e.getMessage());
        }

        RMIServer rmiServer = new RMIServer();
        Naming.rebind("add", rmiServer);
        System.out.println("S-a apelat adunarea");
    }

}
