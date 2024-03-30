package com.mycompany.udp_chat;

import java.net.*;

public class ChatServer {
    private static final int PORT = 12346;

    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(PORT);
            System.out.println("Server started on port " + PORT);

            byte[] receiveData = new byte[1024];

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                System.out.println("Client (" + clientAddress + ":" + clientPort + "): " + message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
