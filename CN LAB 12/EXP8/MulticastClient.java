import java.util.*;
import java.net.*;

public class MulticastClient {
    
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Group Multicast IP: ");
        String group = sc.next()+sc.nextLine();
        System.out.println("Enter port no : ");
        int port = sc.nextInt();


        InetAddress address = InetAddress.getByName(group);

        MulticastSocket socket = new MulticastSocket(port);

        socket.joinGroup(address);

        System.out.println("Joined Multicast Group...");

        while (true) {

            byte[] buffer = new byte[1024];

            DatagramPacket packet =
                    new DatagramPacket(buffer, buffer.length);

            socket.receive(packet);

            String message = new String(packet.getData(), 0, packet.getLength());

            System.out.println("Received: " + message);

            if (message.equalsIgnoreCase("exit"))
                break;
        }

        socket.leaveGroup(address);

        socket.close();
    }
}
