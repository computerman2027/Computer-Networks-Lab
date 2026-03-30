import java.util.Scanner;
import java.util.StringTokenizer;

public class IpAdressIdentification {

    static boolean isValidIpv4(String ip)
    {
        if(ip==null)
            return false;
        StringTokenizer st = new StringTokenizer(ip,".");
        if(st.countTokens()!=4)
        {
            return false;
        }

        try {
            while (st.hasMoreTokens()) {
                String temp = st.nextToken();
                int dectemp = Integer.parseInt(temp);
                if (dectemp < 0 || dectemp > 255) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter IP : ");
        String ip = sc.next()+sc.nextLine();

        if(!isValidIpv4(ip))
        {
            System.out.println("INVALID IP");
            return;
        }
        StringTokenizer ipstr = new StringTokenizer(ip,".");

        int byte1 = Integer.parseInt(ipstr.nextToken());

        if(byte1>=0 && byte1<=127)
        {
            System.out.println("Class A address");
        }
        if(byte1>=128 && byte1<=191)
        {
            System.out.println("Class B address");
        }
        if(byte1>=192 && byte1<=223)
        {
            System.out.println("Class C address");
        }
        if(byte1>=224 && byte1<=239)
        {
            System.out.println("Class D address");
        }
        if(byte1>=240 && byte1<=255)
        {
            System.out.println("Class E address");
        }
    }
}
