import java.util.Scanner;
import java.util.StringTokenizer;

public class IpToBinary {
    public static boolean isValidIPv4_1(String ip) {
        if (ip == null) {
            return false;
        }

        String regex = "^((25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.){3}"
                + "(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})$";

        return ip.matches(regex);
    }

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
        }

        StringTokenizer ipstr = new StringTokenizer(ip,".");

        int k=1;
        String ans ="";
        while (ipstr.hasMoreTokens())
        {
            String str = ipstr.nextToken();
            String binary = String.format("%8s", Integer.toBinaryString(Integer.parseInt(str)))
                    .replace(' ', '0');

            ans = ans+binary;
            if(k<4)
            {
                ans=ans+".";
                k++;
            }
        }

        System.out.println("binary = "+ans);
    }
}
