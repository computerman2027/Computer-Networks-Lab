public class Q3_Supernet {
    public static void main(String[] args) {

        String firstAddress = "205.16.32.0";
        String mask = "255.255.248.0";

        int blockSize = 256 - 248; // third octet

        int start = 32;
        int end = start + blockSize - 1;

        System.out.println("First Address : " + firstAddress);
        System.out.println("Supernet Mask : " + mask);

        System.out.println("Number of Blocks: " + blockSize);

        System.out.println("Address Range:");
        System.out.println("205.16." + start + ".0");
        System.out.println("to");
        System.out.println("205.16." + end + ".255");
    }
}