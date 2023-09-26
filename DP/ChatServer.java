package DP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
public static void main(String[] args) {
        ServerSocket server;
        Socket connection;
        try {
            server = new ServerSocket(2000, 1, InetAddress.getLocalHost());
            connection = server.accept();
            DataInputStream sin = new DataInputStream(connection.getInputStream());
            DataOutputStream sout = new DataOutputStream(connection.getOutputStream());
            DataInputStream myin = new DataInputStream(System.in);
            while (true) {
                System.out.println(sin.readUTF());
                sout.writeUTF(myin.readUTF());
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
