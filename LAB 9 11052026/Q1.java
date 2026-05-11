import java.util.Scanner;

class IpAddress
{
    int term1,term2,term3,term4;


    public IpAddress(int term1, int term2, int term3, int term4) {
        this.term1 = term1;
        this.term2 = term2;
        this.term3 = term3;
        this.term4 = term4;
    }

    @Override
    public String toString() {
        return term1+"."+term2+"."+term3+"."+term4;
    }
}
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter IP : ");
        String inputIp = sc.next();
        String[] iparr = inputIp.split("\\.");

        IpAddress inputIpAddr = new IpAddress(Integer.parseInt(iparr[0]), Integer.parseInt(iparr[1]), Integer.parseInt(iparr[2]), Integer.parseInt(iparr[3]));
        IpAddress classASubnet = new IpAddress(255, 0, 0, 0);

        System.out.println("network address = "+ findNetworkAddress(inputIpAddr,classASubnet));
    }

    static IpAddress findNetworkAddress(IpAddress inputIp, IpAddress subnet)
    {
        return new IpAddress(inputIp.term1 & subnet.term1,
                inputIp.term2 & subnet.term2,
                inputIp.term3 & subnet.term3,
                inputIp.term4 & subnet.term4);
    }
}
