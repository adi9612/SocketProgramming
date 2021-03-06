package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args){

       

        // Spring JPA, JDBC, Project
        // Swing, Applet, Rest APi
        try {
            //multiple thread creation but not executing in parallel
            for (int i = 0; i < 10; i++) {
                Socket socket = new Socket("localhost", 4001);
                System.out.println("I am connected to the server");

                // This is used to read the msg that server has written on the socket (server sent message)
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                // This is used to write to the socket (send msg to server)
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                Scanner scn = new Scanner(System.in);
                String msg;
                do {
                    System.out.println("Enter a msg that needs to be sent to server");
                    msg = scn.nextLine();

                    out.println(msg);

                    //printing the response received from the server
                    String response = in.readLine();
                    System.out.println(response);

                } while (!msg.equals("exit"));
            }
        } catch(UnknownHostException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }

    }
}
