public class Q4_RangeAddress {
    public static void main(String[] args) {

        String ip = "205.16.37.24";
        int prefix = 29;

        int totalAddresses = (int)Math.pow(2, (32 - prefix));

        int start = 24;
        int end = start + totalAddresses - 1;

        System.out.println("Block Address : " + ip + "/" + prefix);

        System.out.println("Total Addresses: " + totalAddresses);

        System.out.println("Range:");
        System.out.println("205.16.37." + start);
        System.out.println("to");
        System.out.println("205.16.37." + end);
    }
}