package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

class udpclient {
    public static void main(String args[]) throws Exception {
//        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");  //ip-ul calculatoruui
        byte[] sendData;
        byte[] receiveData = new byte[1024];
        String sentence = "Test UNU doi TREI";
        sendData = sentence.getBytes();

        Date date = new Date();
        long time1 = date.getTime();

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 3005);
        clientSocket.send(sendPacket);
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        String modifiedSentence = new String(receivePacket.getData());

        Date date2 = new Date();
        long time2 = date2.getTime();

        System.out.println("Serverul a trimis:" + modifiedSentence + "  \n in " + (time2 - time1) + " milisecunde" + "\n dimensiunea:" + receivePacket.getLength());
        clientSocket.close();
    }
}
