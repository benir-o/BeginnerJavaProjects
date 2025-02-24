import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Handles client connections to the Mortgage server.
 *
 * @author Riley Simmons
 */
public class HandleClient extends Thread{

    private final Socket client;
    private final Scanner input;
    private final PrintWriter output;

    /**
     * Define inputs and outputs and connection objects.
     *
     * @param c
     * @throws IOException
     */
    public HandleClient(Socket c) throws IOException {
        client = c;
        input = new Scanner(client.getInputStream());
        output = new PrintWriter(client.getOutputStream(), true);
        System.out.println("Client " + client.getInetAddress() + " Connected");
    }

    /**
     * Loop for getting information from the user through the client and calculating the
     * montage.
     */
    public void run() {

        double principal;
        double rate;
        int months;

        double payment;

        while (true) {
            principal = Double.parseDouble(input.nextLine());
            rate = Double.parseDouble(input.nextLine());
            months = Integer.parseInt(input.nextLine());

            payment = Math.round(new Mortgage(principal, rate, months).getMonthlyPayment());
            System.out.println("Client " + client.getInetAddress() + " calculated a monthly" +
                    " payment of $" + payment);
            output.println(payment);
        }
    }
}
