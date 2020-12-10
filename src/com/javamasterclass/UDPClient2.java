package com.javamasterclass;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class UDPClient2 {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getLocalHost(); // getByName()
            DatagramSocket datagramSocket = new DatagramSocket();

            Scanner scanner = new Scanner(System.in);
            String echoString;

            do {
                System.out.println("Enter sting to be echoed: ");
                echoString = scanner.nextLine();

                byte[] buffer = echoString.getBytes();
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 5000);
                datagramSocket.send(packet);
            } while (!echoString.equals("exit"));
        } catch (SocketTimeoutException e){
            System.out.println("The socket timed out");
        } catch (IOException e){
            System.out.println("Client error" + e.getMessage());
        }
    }
}
