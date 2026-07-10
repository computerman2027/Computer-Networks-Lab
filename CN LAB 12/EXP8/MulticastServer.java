import java.util.*;
import java.net.*;


public class MulticastServer {

    public static void main(String[] args) throws Exception{
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Group Multicast IP: ");
        String group = sc.next()+sc.nextLine();
        System.out.println("Enter port no : ");
        int port = sc.nextInt();

        InetAddress address = InetAddress.getByName(group);

        DatagramSocket socket = new DatagramSocket();

        System.out.println("Multicast Server Started");

        while (true) {

            System.out.print("Enter message: ");
            String message = sc.nextLine();

            

            byte[] buffer = message.getBytes();

            DatagramPacket packet =
                    new DatagramPacket(buffer, buffer.length, address, port);

            socket.send(packet);

            System.out.println("Message Sent");

            if (message.equalsIgnoreCase("exit"))
                break;
        }

        socket.close();
        sc.close();
        
    }
}