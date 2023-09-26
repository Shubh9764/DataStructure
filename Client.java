import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;

import java.io.DataOutputStream;

public class Client {
    public static void main(String[]args) throws Exception {
        Socket client;
        client = new Socket(InetAddress.getLocalHost(), 2000);
        DataInputStream sin = new DataInputStream(client.getInputStream());
        DataOutputStream sout = new DataOutputStream(client.getOutputStream());
        DataInputStream myin = new DataInputStream(System.in);
    }

}
