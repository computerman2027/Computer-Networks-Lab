import java.io.*;
import java.net.*;

public class MyServer2 {

    public static void main(String[] args) {
        try{
            ServerSocket ss = new ServerSocket(6666);

            System.out.printf("SERVER READY AT PORT = %s\n",ss.getLocalSocketAddress());
            Socket s = ss.accept();
            System.out.println("Client Port = " + s.getPort());
            DataInputStream dis = new DataInputStream(s.getInputStream());

            String str = (String)dis.readUTF();

            System.out.printf("Message = %s\n",str);

            ss.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}