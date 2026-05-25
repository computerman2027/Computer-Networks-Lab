package EXP6;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class ServerQ1 {

    public static void main(String[] args) {
        try
        {
            ServerSocket ss = new ServerSocket(6666);

            System.out.printf("SERVER READY AT PORT = %s\n",ss.getLocalSocketAddress());

            Socket s = ss.accept();

            DataInputStream dis = new DataInputStream(s.getInputStream());

            String str = (String)dis.readUTF();

            if(str.equalsIgnoreCase("time"))
            {
                System.out.println(LocalDateTime.now());
            }
            ss.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
