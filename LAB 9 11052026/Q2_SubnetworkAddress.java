public class Q2_SubnetworkAddress {
    public static void main(String[] args) {

        String ip = "200.45.34.56";
        String mask = "255.255.240.0";

        String[] ipParts = ip.split("\\.");
        String[] maskParts = mask.split("\\.");

        int[] subnet = new int[4];

        for (int i = 0; i < 4; i++) {
            subnet[i] =
                    Integer.parseInt(ipParts[i]) &
                            Integer.parseInt(maskParts[i]);
        }

        System.out.println("Destination Address : " + ip);
        System.out.println("Subnet Mask         : " + mask);

        System.out.println("Subnetwork Address  : " +
                subnet[0] + "." +
                subnet[1] + "." +
                subnet[2] + "." +
                subnet[3]);
    }
}