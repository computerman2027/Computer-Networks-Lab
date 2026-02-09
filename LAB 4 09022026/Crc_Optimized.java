import java.util.Scanner;

public class Crc_Optimized {

    // XOR operation
    static char xor(char a, char b) {
        return (a == b) ? '0' : '1';
    }

    // Performs CRC division and returns remainder
    static String divide(String data, String divisor) {
        int n = divisor.length();
        char[] temp = data.substring(0, n).toCharArray();
        char[] divisorArr = divisor.toCharArray();

        for (int i = n; i <= data.length(); i++) {

            // Perform XOR if leading bit is 1
            if (temp[0] == '1') {
                for (int j = 0; j < n; j++) {
                    temp[j] = xor(temp[j], divisorArr[j]);
                }
            }

            // Shift left and bring next bit
            if (i < data.length()) {
                for (int j = 0; j < n - 1; j++) {
                    temp[j] = temp[j + 1];
                }
                temp[n - 1] = data.charAt(i);
            }
        }

        // Remainder is first n-1 bits
        return new String(temp, 0, n - 1);
    }

    // Generate CRC codeword
    static String generateCRC(String data, String divisor) {
        StringBuilder paddedData = new StringBuilder(data);
        paddedData.append("0".repeat(divisor.length() - 1));

        String remainder = divide(paddedData.toString(), divisor);
        return data + remainder;
    }

    // Check received data
    static boolean checkCRC(String receivedData, String divisor) {
        String remainder = divide(receivedData, divisor);
        return !remainder.contains("1");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter data: ");
        String data = sc.nextLine();

        System.out.print("Enter divisor: ");
        String divisor = sc.nextLine();

        String transmittedData = generateCRC(data, divisor);
        System.out.println("Transmitted data: " + transmittedData);

        System.out.print("Enter received data: ");
        String receivedData = sc.nextLine();

        if (checkCRC(receivedData, divisor)) {
            System.out.println("Data is correct");
        } else {
            System.out.println("Data is incorrect");
        }
    }
}
