package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

public class URLReader {
    public static void main(String[] args) throws Exception {
        URL yahoo = new URL("http://www.yahoo.com/");
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yahoo.openStream()));
        String s;
        while ((s = in.readLine()) != null)
            System.out.println("out :"+s);
        in.close();
    }
}
