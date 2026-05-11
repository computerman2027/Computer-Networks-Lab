import java.util.Scanner;

class IpAddress2 {
    int[] term = new int[4];

    IpAddress2(String ip) {
        String[] parts = ip.split("\\.");

        for (int i = 0; i < 4; i++) {
            term[i] = Integer.parseInt(parts[i]);
        }
    }

    IpAddress2(int[] arr) {
        term = arr;
    }

    static IpAddress2 findNetworkAddress(IpAddress2 ip, IpAddress2 subnet) {
        int[] result = new int[4];

        for (int i = 0; i < 4; i++) {
            result[i] = ip.term[i] & subnet.term[i];
        }

        return new IpAddress2(result);
    }

    @Override
    public String toString() {
        return term[0] + "." + term[1] + "." + term[2] + "." + term[3];
    }
}

public class Q1_1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter IP : ");

        IpAddress2 ip = new IpAddress2(sc.next());
        IpAddress2 subnet = new IpAddress2("255.0.0.0");

        System.out.println("Network Address = "
                + IpAddress2.findNetworkAddress(ip, subnet));
    }
}