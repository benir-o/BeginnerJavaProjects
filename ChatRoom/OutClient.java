package BeginnerJavaProjects.ChatRoom;
import java.util.Scanner;

/**
 * Handles information that is coming in from the server and it to be displayed
 * out to the console.
 *
 * @author Riley Simmons
 */
public class OutClient extends Thread
{

    Scanner serverIn;

    public OutClient(Scanner in) {
        serverIn = in;
    }

    /**
     * Continuously receive and display messages from the server.
     */
    public void run()
    {
        while (true)
        {
            System.out.println(serverIn.nextLine());
        }
    }
}
