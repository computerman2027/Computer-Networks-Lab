import java.io.*;
import java.net.*;

public class MyClient2 {

    public static void main(String[] args) {
        try
        {
            Socket s = new Socket("localhost",6666);
            System.out.println("Client Port = " + s.getLocalPort());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF("hello server");
            dout.flush();
            dout.close();

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}