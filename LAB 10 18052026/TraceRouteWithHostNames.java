import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TraceRouteWithHostNames {

    public static void main(String[] args) {

        try {

            BufferedReader br =
                    new BufferedReader(new InputStreamReader(System.in));

            // Input hostname
            System.out.print("Enter Host Name: ");
            String host = br.readLine();

            // Detect OS
            String os = System.getProperty("os.name").toLowerCase();

            String command;

            if (os.contains("win")) {
                command = "tracert " + host;
            } else {
                command = "traceroute " + host;
            }

            // Execute command
            Process process = Runtime.getRuntime().exec(command);

            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(process.getInputStream()));

            String line;

            // Regex for IP extraction
            Pattern pattern =
                    Pattern.compile(
                            "\\b(?:\\d{1,3}\\.){3}\\d{1,3}\\b");

            System.out.println("\nTracing Route:\n");

            while ((line = reader.readLine()) != null) {

                System.out.println(line);

                // Find IPs in each line
                Matcher matcher = pattern.matcher(line);

                while (matcher.find()) {

                    String ip = matcher.group();

                    try {

                        // Get hostname from IP
                        InetAddress address =
                                InetAddress.getByName(ip);

                        System.out.println(
                                " IP Address : " + ip);

                        System.out.println(
                                " Host Name : "
                                        + address.getHostName());

                    } catch (Exception e) {

                        System.out.println(
                                " Unable to resolve host for IP: "
                                        + ip);
                    }
                }
            }

            reader.close();

        } catch (Exception e) {

            System.out.println("Error: " + e);
        }
    }
}