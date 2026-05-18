import java.util.Scanner;

public class SupernetMask {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of IP addresses: ");
        int n = sc.nextInt();

        int[][] ip = new int[n][4];

        System.out.println("Enter IP addresses:");

        // Input
        for (int i = 0; i < n; i++) {

            String s = sc.next();

            String[] parts = s.split("\\.");

            for (int j = 0; j < 4; j++) {
                ip[i][j] = Integer.parseInt(parts[j]);
            }
        }

        int[] mask = new int[4];

        boolean stop = false;

        for (int octet = 0; octet < 4; octet++) {

            if (stop) {
                mask[octet] = 0;
                continue;
            }

            int xor = 0;

            // XOR all IPs with first IP
            for (int i = 1; i < n; i++) {
                xor |= (ip[0][octet] ^ ip[i][octet]);
            }

            // Build mask from left-side common bits
            int currentMask = 0;

            for (int bit = 7; bit >= 0; bit--) {

                if ((xor & (1 << bit)) == 0) {
                    currentMask |= (1 << bit);
                } else {
                    stop = true;
                    break;
                }
            }

            mask[octet] = currentMask;
        }

        System.out.print("\nSupernet Mask: ");

        for (int i = 0; i < 4; i++) {

            System.out.print(mask[i]);

            if (i != 3) {
                System.out.print(".");
            }
        }

        sc.close();
    }
}