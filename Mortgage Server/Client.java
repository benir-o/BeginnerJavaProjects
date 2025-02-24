import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * The client that can connect to the mortgage server to retrieve a monthly payment
 * with provided principal, rate, and how many months.
 */
public class Client {
    public static void main(String[] args) throws IOException {

        Socket server = new Socket("127.0.0.1", 8000);

        System.out.println("Connected to Server");

        Scanner input = new Scanner(server.getInputStream());
        Scanner keyboard = new Scanner(System.in);
        PrintWriter output = new PrintWriter(server.getOutputStream(), true);

        while (true) {
            System.out.print("Enter your principal: ");
            output.println(keyboard.nextLine());
            System.out.print("Enter your rate: ");
            output.println(keyboard.nextLine());
            System.out.print("Enter how many months: ");
            output.println(keyboard.nextLine());
            System.out.println("Your monthly payment on the mortgage will be $" + input.nextLine());
        }
    }
}
