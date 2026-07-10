import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true);

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter a lowercase string: ");
            String message = sc.nextLine();

            // Send to server
            out.println(message);

            // Receive uppercase string
            String response = in.readLine();

            System.out.println("Uppercase from Server: " + response);

            socket.close();
            sc.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}