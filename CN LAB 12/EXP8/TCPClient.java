import java.io.*;
import java.net.*;
import java.util.*;

public class TCPClient {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Server IP: ");
        String ip = sc.nextLine();

        System.out.print("Enter Port: ");
        int port = Integer.parseInt(sc.nextLine());

        Socket socket = new Socket(ip, port);

        DataInputStream in =
                new DataInputStream(socket.getInputStream());

        System.out.println("Connected to Server");

        while (true) {

            String message = in.readUTF();

            System.out.println("Received : " + message);

            if (message.equalsIgnoreCase("exit"))
                break;
        }

        socket.close();
    }
}