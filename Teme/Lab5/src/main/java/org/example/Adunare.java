package org.example;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Adunare extends Remote {
    int addNumbers(int a[]) throws RemoteException;

}
