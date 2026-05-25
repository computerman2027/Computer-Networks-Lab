package EXP6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class ServerQ2_2 {

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(3333);

            Socket s = ss.accept();

            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String str = "";
            while (true)
            {
                str=din.readUTF();
                System.out.println("client says : "+str);
                if(str.equalsIgnoreCase("time"))
                {
                    dout.writeUTF("Time = "+ LocalDateTime.now());
                    break;
                }
                else
                {
                    dout.writeUTF("Invalid command");
                }
            }
            din.close();
            s.close();
            ss.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
