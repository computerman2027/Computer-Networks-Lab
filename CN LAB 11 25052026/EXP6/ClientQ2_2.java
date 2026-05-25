package EXP6;

import java.io.*;
import java.net.Socket;

public class ClientQ2_2 {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 3333);
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String str = "", str2 = "";
            while (true) {
                str = br.readLine();
                dout.writeUTF(str);
                dout.flush();
                str2 = din.readUTF();
                if(str.equalsIgnoreCase("time"))
                {
                    System.out.println("server time : "+str2);
                    break;
                }
                else
                {
                    System.out.println("server response : "+str2);
                }
            }
            dout.close();
            s.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
