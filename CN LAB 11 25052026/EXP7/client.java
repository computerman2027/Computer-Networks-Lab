package EXP7;

import java.io.DataOutputStream;
import java.net.Socket;

public class client {

    public static void main(String[] args) {
        try
        {
            Socket s = new Socket("localhost",6666);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF("hello EXP7.server");
            dout.flush();
            dout.close();

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
