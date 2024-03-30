package com.mycompany.udp_chat;

import java.net.*;
import java.util.Scanner;

public class ChatClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12346;

    public static void main(String[] args) {
        try {
            DatagramSocket clientSocket = new DatagramSocket();

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your message: ");

            while (true) {
                String message = scanner.nextLine();
                byte[] sendData = message.getBytes();
                InetAddress serverAddress = InetAddress.getByName(SERVER_ADDRESS);
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, SERVER_PORT);

                clientSocket.send(sendPacket);

                if (message.equalsIgnoreCase("bye")) {
                    System.out.println("Closing connection...");
                    break;
                }
            }

            clientSocket.close();
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
