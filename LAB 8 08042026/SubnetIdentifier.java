import java.util.Scanner;
import java.util.StringTokenizer;

public class SubnetIdentifier {

    static int[] findNetworkAddress(String[] ip, int[] subnet)
    {
        int[] ans = new int[4];

        for(int i = 0;i<4;i++)
        {
            ans[i]=Integer.parseInt(ip[i]) & subnet[i];
        }
        return ans;
    }

    static int[] findBroadcastAddress(String[] ip, int[] subnet)
    {
        int[] ans = new int[4];

        for(int i = 0;i<4;i++)
        {
            ans[i] = ((Integer.parseInt(ip[i]) & subnet[i]) | (~subnet[i] & 255));
        }
        return ans;
    }

    static int classIndentifier(String ip)
    {
        StringTokenizer ipstr = new StringTokenizer(ip,".");

        int byte1 = Integer.parseInt(ipstr.nextToken());

        if(byte1>=0 && byte1<=127)
        {
            return 1;
        }
        if(byte1>=128 && byte1<=191)
        {
            return 2;
        }
        if(byte1>=192 && byte1<=223)
        {
            return 3;
        }
        if(byte1>=224 && byte1<=239)
        {
            return 4;
        }
        if(byte1>=240 && byte1<=255)
        {
            return 5;
        }
        return -1;
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

        String[] ipstr= ip.split("\\.");

        int classNo = classIndentifier(ip);

        int[] subnet=new int[4];

        if(classNo==1)
        {
            subnet[0]=255;
            subnet[1]=128;
        }
        else if(classNo==2)
        {
            subnet[0]=255;
            subnet[1]=255;
            subnet[2]=128;
        }
        else if(classNo==3)
        {
            subnet[0]=255;
            subnet[1]=255;
            subnet[2]=255;
            subnet[3]=128;
        }

        System.out.printf("subnet address : %d.%d.%d.%d\n",subnet[0],subnet[1],subnet[2],subnet[3]);

        if(classNo==1)
        {
            System.out.printf("subnetwork address 1 : %s.%s.%s.%s\n",ipstr[0],"0","0","0");
            System.out.printf("subnetwork address 1 : %s.%s.%s.%s\n",ipstr[0],"128","0","0");
            System.out.println("No of host in each subnetwork = "+(128*255*255));

            String[] ip2 = {ipstr[0], "128","0","0"};
            int[] sub1a1 = findNetworkAddress(ipstr,subnet);
            int[] sub1a2 = findBroadcastAddress(ipstr,subnet);
            int[] sub2a1 = findNetworkAddress(ip2,subnet);
            int[] sub2a2 = findBroadcastAddress(ip2,subnet);

            System.out.printf("subnet 1 network address = %d.%d.%d.%d\n",sub1a1[0],sub1a1[1],sub1a1[2],sub1a1[3]);
            System.out.printf("subnet 1 broadcast address = %d.%d.%d.%d\n",sub1a2[0],sub1a2[1],sub1a2[2],sub1a2[3]);
            System.out.printf("subnet 2 network address = %d.%d.%d.%d\n",sub2a1[0],sub2a1[1],sub2a1[2],sub2a1[3]);
            System.out.printf("subnet 2 broadcast address = %d.%d.%d.%d\n",sub2a2[0],sub2a2[1],sub2a2[2],sub2a2[3]);


            System.out.println("No of usable ip ADDRESS in each subnetwork = "+((128*255*255)-2));

        }

        if(classNo==2)
        {
            System.out.printf("subnetwork address 1 : %s.%s.%s.%s\n",ipstr[0],ipstr[1],"0","0");
            System.out.printf("subnetwork address 1 : %s.%s.%s.%s\n",ipstr[0],ipstr[1],"128","0");
            System.out.println("No of host in each subnetwork = "+(128*255));

            String[] ip2 = {ipstr[0],ipstr[1], "128","0"};
            int[] sub1a1 = findNetworkAddress(ipstr,subnet);
            int[] sub1a2 = findBroadcastAddress(ipstr,subnet);
            int[] sub2a1 = findNetworkAddress(ip2,subnet);
            int[] sub2a2 = findBroadcastAddress(ip2,subnet);

            System.out.printf("subnet 1 network address = %d.%d.%d.%d\n",sub1a1[0],sub1a1[1],sub1a1[2],sub1a1[3]);
            System.out.printf("subnet 1 broadcast address = %d.%d.%d.%d\n",sub1a2[0],sub1a2[1],sub1a2[2],sub1a2[3]);
            System.out.printf("subnet 2 network address = %d.%d.%d.%d\n",sub2a1[0],sub2a1[1],sub2a1[2],sub2a1[3]);
            System.out.printf("subnet 2 broadcast address = %d.%d.%d.%d\n",sub2a2[0],sub2a2[1],sub2a2[2],sub2a2[3]);
            System.out.println("No of usable ip ADDRESS in each subnetwork = "+((128*255)-2));

        }
        if(classNo==3)
        {
            System.out.printf("subnetwork address 1 : %s.%s.%s.%s\n",ipstr[0],ipstr[1],ipstr[2],"0");
            System.out.printf("subnetwork address 1 : %s.%s.%s.%s\n",ipstr[0],ipstr[1],ipstr[2],"128");
            System.out.println("No of host in each subnetwork = "+(128));

            String[] ip2 = {ipstr[0], ipstr[1], ipstr[2], "128"};
            int[] sub1a1 = findNetworkAddress(ipstr,subnet);
            int[] sub1a2 = findBroadcastAddress(ipstr,subnet);
            int[] sub2a1 = findNetworkAddress(ip2,subnet);
            int[] sub2a2 = findBroadcastAddress(ip2,subnet);

            System.out.printf("subnet 1 network address = %d.%d.%d.%d\n",sub1a1[0],sub1a1[1],sub1a1[2],sub1a1[3]);
            System.out.printf("subnet 1 broadcast address = %d.%d.%d.%d\n",sub1a2[0],sub1a2[1],sub1a2[2],sub1a2[3]);
            System.out.printf("subnet 2 network address = %d.%d.%d.%d\n",sub2a1[0],sub2a1[1],sub2a1[2],sub2a1[3]);
            System.out.printf("subnet 2 broadcast address = %d.%d.%d.%d\n",sub2a2[0],sub2a2[1],sub2a2[2],sub2a2[3]);
            System.out.println("No of usable ip ADDRESS in each subnetwork = "+((128)-2));

        }

    }
}
