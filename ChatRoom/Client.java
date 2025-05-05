package BeginnerJavaProjects.ChatRoom;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Handles the basic setup of the client for the chat program by connecting to the
 * server, and then launching an input and output thread for chatting with other users.
 *
 * @author Riley Simmons
 */
public class Client {
    public static void main(String[] args) throws IOException, InterruptedException
    {
        boolean connected = false;
        Socket server = null;

        // Try to connect in a loop, in case server is not active yet or connection is bad
        while (!connected)
        {
            try
            {
                server = new Socket("127.0.0.1", 8000);
                connected = true;
            } catch (ConnectException e)
            {
                System.out.println("Unable to connect to server, retrying...");
                Thread.sleep(2000);
            }
        }

        // Define inputs and outputs for the user
        Scanner input = new Scanner(server.getInputStream());
        Scanner keyboard = new Scanner(System.in);
        PrintWriter output = new PrintWriter(server.getOutputStream(), true);

        // Collect required information form the user
        System.out.print("Username: ");
        String username = keyboard.nextLine();
        output.println(username);
        System.out.println(input.nextLine());

        // Launch input and output threads
        Thread InThread = new InClient(keyboard, output);
        Thread OutThread = new OutClient(input);
        InThread.start();
        OutThread.start();
    }
}
