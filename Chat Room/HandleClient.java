import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

/**
 * Handles one client on behalf of the server.
 *
 * @author Riley Simmons
 */
public class HandleClient extends Thread
{

    private final Socket client;
    private final Scanner input;
    private final PrintWriter output;
    private final Server server;

    /**
     * Set up constant objects that will be needed for later.
     *
     * @param s The socket connection to the associated client.
     * @param server The instance of the main server.
     */
    public HandleClient(Socket s, Server server) throws IOException
    {
        client = s;
        input = new Scanner(client.getInputStream());
        output = new PrintWriter(client.getOutputStream(), true);
        this.server = server;
        System.out.println("Client " + s.getInetAddress() + " Connected");
    }

    /**
     * Runs as a thread, and contains a loop that receives information from the client
     * and processes it.
     */
    public void run()
    {
        // Finds username and adds it to the list
        String username;
        synchronized (server)
        {
            username = input.nextLine();
            server.addUser(username, client);
            Server.sendClient(output, mapToString(server.getUsers()));
        }
        System.out.println("User '" + username + "' has joined");
        try
        {
            server.broadcast("User '" + username + "' has joined");
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        Server.sendClient(output, Server.instructions);

        // Define variable that will be modified in the loop
        String clientMessage;
        String user = null;
        String message;
        while (true)
        {
            try
            {
                clientMessage = input.nextLine();
            } catch (NoSuchElementException e)
            { // For when a user leaves / disconnects
                System.out.println("User " + username + " has disconnected.");
                broadcastAll(server, "User " + username + " has disconnected.");
                break;
            }

            if (clientMessage.contains(" "))
            {
                user = clientMessage.substring(0, clientMessage.indexOf(' '));
            }
            message = clientMessage.substring(clientMessage.indexOf(' ') + 1);

            if (clientMessage.equals("list"))
            {
                sendToUsername(server, username, mapToString(server.getUsers()));
                continue;
            }
            if (clientMessage.startsWith("all"))
            {
                broadcastAll(server, username + ": " + message);
                continue;
            }

            if (server.getUsers().containsKey(user))
            {
                System.out.println("'" + username + "' said '" + message + "' to '" + user + "'.");
                sendToUsername(server, user, username + ": " + message);
            } else
            {
                System.out.println(username + " tried to send a message with no valid user");
                sendToUsername(server, username, "No valid user found.");
            }
        }
    }

    /**
     * Used to send a message to a specific client given the client's assigned username,
     * also used to clean up code in the run method and make it more readable.
     *
     * @param server The instance of the server that spawned this thread.
     * @param username The username of the client that is being addressed.
     * @param message The message that will be sent to the client.
     */
    private void sendToUsername(Server server, String username, String message)
    {
        try
        {
            server.sendClient(username, message);
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * Uses the broadcast method from the server and catches any errors thrown by
     * the server. Also used to clean up the code in the run method.
     *
     * @param server The server object that spawned this.
     * @param message The message to be sent to all users.
     */
    private void broadcastAll(Server server, String message)
    {
        try
        {
            server.broadcast(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Takes the user-connection map from the server and make it a readable
     * list for the user.
     *
     * @param users The map object from the server
     * @return The string representation of the username - address map.
     */
    private String mapToString(Map<String, Socket> users)
    {
        String s = "";
        Set<String> keys = users.keySet();
        s+= "[";
        for (String e : keys)
        {
            s += "(" + e + ", " + users.get(e).getInetAddress() + "), ";
        }
        return s + "]";
    }
}
