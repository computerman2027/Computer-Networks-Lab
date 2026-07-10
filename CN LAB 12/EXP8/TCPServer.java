import java.io.*;
import java.net.*;
import java.util.*;

public class TCPServer {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Port: ");
        int port = Integer.parseInt(sc.nextLine());

        ServerSocket serverSocket = new ServerSocket(port);

        List<Socket> clients = new ArrayList<>();

        System.out.println("Server Started...");

        // Thread to accept clients
        new Thread(() -> {
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    clients.add(socket);
                    System.out.println("Client Connected : "
                            + socket.getInetAddress());
                } catch (Exception e) {
                    break;
                }
            }
        }).start();

        while (true) {

            System.out.print("Enter Message: ");
            String message = sc.nextLine();

            for (Iterator<Socket> it = clients.iterator(); it.hasNext();) {

                Socket client = it.next();

                try {
                    DataOutputStream out =
                            new DataOutputStream(client.getOutputStream());

                    out.writeUTF(message);
                    out.flush();

                } catch (IOException e) {
                    it.remove();
                }
            }

            if (message.equalsIgnoreCase("exit"))
                break;
        }

        for (Socket s : clients)
            s.close();

        serverSocket.close();
        sc.close();
    }
}