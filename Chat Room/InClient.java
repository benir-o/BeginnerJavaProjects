import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Handles the user input into the console.
 *
 * @author Riley Simmons
 */
public class InClient extends Thread
{
    Scanner keyboard;
    PrintWriter output;

    /**
     * Define IO systems
     *
     * @param scan The Scanner object that retrieves user input
     * @param output The PrintWriter object that sends the input to the server.
     */
    public InClient(Scanner scan, PrintWriter output)
    {
        keyboard = scan;
        this.output = output;
    }

    /**
     * The main loop for collecting user input and sending it to the server.
     */
    public void run()
    {
        String input;
        while (true)
        {
            input = keyboard.nextLine();

            if (input.equals("quit"))
            {
                System.exit(0);
            }

            output.println(input);
        }
    }
}