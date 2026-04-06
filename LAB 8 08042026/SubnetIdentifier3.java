import java.util.*;

public class SubnetIdentifier3 {

    static int[] findNetworkAddress(int[] ip, int[] subnet) {
        int[] ans = new int[4];
        for (int i = 0; i < 4; i++)
            ans[i] = ip[i] & subnet[i];
        return ans;
    }

    static int[] findBroadcastAddress(int[] ip, int[] subnet) {
        int[] ans = new int[4];
        for (int i = 0; i < 4; i++)
            ans[i] = (ip[i] & subnet[i]) | (~subnet[i] & 255);
        return ans;
    }

    static int classIdentifier(int firstByte) {
        if (firstByte <= 127) return 1;
        if (firstByte <= 191) return 2;
        if (firstByte <= 223) return 3;
        if (firstByte <= 239) return 4;
        return 5;
    }

    static boolean isValidIpv4(String ip) {
        String[] parts = ip.split("\\.");
        if (parts.length != 4) return false;

        try {
            for (String p : parts) {
                int n = Integer.parseInt(p);
                if (n < 0 || n > 255) return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    static int[] parseIP(String ip) {
        String[] parts = ip.split("\\.");
        int[] res = new int[4];
        for (int i = 0; i < 4; i++)
            res[i] = Integer.parseInt(parts[i]);
        return res;
    }

    static void printIP(int[] ip) {
        System.out.printf("%d.%d.%d.%d\n", ip[0], ip[1], ip[2], ip[3]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter IP: ");
        String ipStr = sc.nextLine();

        if (!isValidIpv4(ipStr)) {
            System.out.println("INVALID IP");
            return;
        }

        int[] ip = parseIP(ipStr);
        int classNo = classIdentifier(ip[0]);

        int[] subnet = new int[4];


        for (int i = 0; i < classNo; i++)
            subnet[i] = 255;

        if (classNo <= 3)
            subnet[classNo] = 128;

        System.out.print("Subnet mask: ");
        printIP(subnet);


        int[] ip2 = ip.clone();
        ip2[classNo] = 128;

        int[] net1 = findNetworkAddress(ip, subnet);
        int[] broad1 = findBroadcastAddress(ip, subnet);
        int[] net2 = findNetworkAddress(ip2, subnet);
        int[] broad2 = findBroadcastAddress(ip2, subnet);

        System.out.print("Subnet 1 Network: ");
        printIP(net1);
        System.out.print("Subnet 1 Broadcast: ");
        printIP(broad1);

        System.out.print("Subnet 2 Network: ");
        printIP(net2);
        System.out.print("Subnet 2 Broadcast: ");
        printIP(broad2);

        int hosts = (int)Math.pow(2, (8 * (4 - classNo - 1))) * 128;
        System.out.println("Hosts per subnet: " + hosts);
        System.out.println("Usable hosts per subnetwork: " + (hosts - 2));
    }
}