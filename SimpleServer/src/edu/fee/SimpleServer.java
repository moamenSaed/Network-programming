package edu.fee;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SimpleServer {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        ServerSocket serverSocket = new ServerSocket(5050);
        System.out.println("Server started at port 5050");
        Socket socket = serverSocket.accept();
        System.out.println("Server got a client");

        OutputStream socketOutputStream = socket.getOutputStream();
        DataOutputStream socketDOS = new DataOutputStream(socketOutputStream);


        
        System.out.print("please send ur message: ");
        String serverMsg = input.nextLine();
        socketDOS.writeUTF(serverMsg);
        


        InputStream socketInputStream = socket.getInputStream();
        DataInputStream socketDIS = new DataInputStream(socketInputStream);

        String clientResponse = socketDIS.readUTF();
        System.out.println(clientResponse);


        socketDOS.close();
        socketDIS.close();
        socketOutputStream.close();
        socketInputStream.close();
        socket.close();
        serverSocket.close();

    }
}