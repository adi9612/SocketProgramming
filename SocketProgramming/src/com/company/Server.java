package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try {
            //creates a server socket
            ServerSocket socket = new ServerSocket(4000);
            System.out.println("Waiting for the client to connect");
            //blocking like thread.join() till the time client is connected to server socket
            Socket clientSocket = socket.accept();
            System.out.println("Client is connected");

            //used to read input
            //System.in means reading from console but we have to read from clientSocket
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            //acknowledge to the client, writing to the socket
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            while(true){
                String msg = in.readLine();
                System.out.println("Client sent: " + msg);
                out.println("Server acknowledge this message : " + msg);

                if(msg.equals("exit")){
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
