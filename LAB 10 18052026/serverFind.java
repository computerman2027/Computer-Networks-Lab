import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class serverFind {

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter server IP : ");

        String serverIp = sc.next();

        InetAddress server = InetAddress.getByName(serverIp);

        System.out.println("server name = "+ server.getHostName()+
                "\naddress = "+server.getHostAddress() +
                "\nCanonical Host Name = "+server.getCanonicalHostName());

        System.out.println(server);

        String host = serverIp;
        String os = System.getProperty("os.name").toLowerCase();

        String command;

        if (os.contains("win")) {
            command = "tracert " + host;
        } else {
            command = "traceroute " + host;
        }

        Process process = Runtime.getRuntime().exec(command);

        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(process.getInputStream()));

        String line;

        Pattern pattern =
                Pattern.compile("\\b(?:\\d{1,3}\\.){3}\\d{1,3}\\b");

        System.out.println("\nPath Details:\n");

        while ((line = reader.readLine()) != null) {

            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {

                String ip = matcher.group();

                try {

                    InetAddress address =
                            InetAddress.getByName(ip);

//                    System.out.println("IP Address : " + ip);
//                    System.out.println("Host Name : "
//                            + address.getHostName());
//                    System.out.println();

                    System.out.printf("%s --> %s\n",ip,address.getHostName());

                } catch (Exception e) {

                    System.out.println("IP Address : " + ip);
                    System.out.println("Host Name : Not Found\n");
                }
            }
        }

        reader.close();

    }

}