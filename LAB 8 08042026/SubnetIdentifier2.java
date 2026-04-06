import java.util.*;

public class SubnetIdentifier2 {

    static int[] getAddress(String[] ip, int[] mask, boolean isBroadcast) {
        int[] res = new int[4];
        for (int i = 0; i < 4; i++) {
            int val = Integer.parseInt(ip[i]) & mask[i];
            if (isBroadcast) val |= (~mask[i] & 255);
            res[i] = val;
        }
        return res;
    }

    static int getClass(String ip) {
        int first = Integer.parseInt(ip.split("\\.")[0]);
        if (first <= 127) return 1;
        if (first <= 191) return 2;
        if (first <= 223) return 3;
        if (first <= 239) return 4;
        return 5;
    }

    static boolean isValid(String ip) {
        String[] parts = ip.split("\\.");
        if (parts.length != 4) return false;
        try {
            for (String p : parts) {
                int n = Integer.parseInt(p);
                if (n < 0 || n > 255) return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter IP: ");
        String ip = sc.nextLine();

        if (!isValid(ip)) {
            System.out.println("INVALID IP");
            return;
        }

        String[] ipParts = ip.split("\\.");
        int cls = getClass(ip);

        int[] mask = {255, 0, 0, 0};


        for (int i = 1; i < cls; i++) {
            mask[i] = 255;
        }
        mask[cls] = 128;

        System.out.printf("Subnet Mask: %d.%d.%d.%d\n",
                mask[0], mask[1], mask[2], mask[3]);

        int[] net1 = getAddress(ipParts, mask, false);
        int[] broad1 = getAddress(ipParts, mask, true);


        String[] ip2 = ipParts.clone();
        ip2[cls] = "128";

        int[] net2 = getAddress(ip2, mask, false);
        int[] broad2 = getAddress(ip2, mask, true);

        System.out.printf("Subnet 1 Network: %s\n",
                Arrays.toString(net1).replaceAll("[\\[\\],]", "."));
        System.out.printf("Subnet 1 Broadcast: %s\n",
                Arrays.toString(broad1).replaceAll("[\\[\\],]", "."));
        System.out.printf("Subnet 2 Network: %s\n",
                Arrays.toString(net2).replaceAll("[\\[\\],]", "."));
        System.out.printf("Subnet 2 Broadcast: %s\n",
                Arrays.toString(broad2).replaceAll("[\\[\\],]", "."));

        int hosts = (int) Math.pow(2, (4 - cls) * 8 - 1);
        System.out.println("Hosts per subnet: " + hosts);
        System.out.println("Usable hosts: " + (hosts - 2));
    }
}