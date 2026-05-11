import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class AddressFinding {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {


            InetAddress localIp = InetAddress.getLocalHost();
            System.out.println("local host = " + localIp.getHostAddress());

        } catch (UnknownHostException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.print("Enter server name : ");

        String serverName = sc.next();
        try
        {
            InetAddress serverAddress = InetAddress.getByName(serverName);
            System.out.printf("%s address = %s\n", serverName, serverAddress.getHostAddress());
        }
        catch (UnknownHostException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
