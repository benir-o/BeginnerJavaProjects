import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * This is a class that accepts socket connections from clients, and spawns HandleClient
 * threads that handle chatting logic for each client. This class also keeps track of the
 * users with a map with usernames and connections, and has methods for the HandleClient
 * threads to use.
 *
 * @author Riley Simmons
 */
public class Server
{
    public static Map<String, Socket> userMap = new HashMap<String, Socket>();

    private final static int maxClients = 10;

    // Instructions on how to use the client that are sent when they connect.
    public final static String instructions = """
            First type the username of the client that you want to chat with, followed by a space and then your message.
            To message all clients, type 'all' in the user field.
            Type 'quit' to quit.
            Type 'list' to view all connected users.""";

    /**
     * This is needed so that an instance of the server can be passed to each thread, for
     * use of instance methods and the userMap object.
     */
    public static void main(String[] args) throws IOException
    {
        new Server();
    }

    /**
     * Runs a loop that accepts connections and then creates new threads for each
     * new connected client.
     *
     */
    private Server() throws IOException
    {
        ServerSocket server = new ServerSocket(8000);

        for (int i = 0; i < maxClients; i++)
        {
            Socket client = server.accept();
            Thread clientThread = new HandleClient(client, this);
            clientThread.start();
        }
    }

    /**
     * Adds a new user to the userMap map.
     *
     * @param name The username of the user.
     * @param s The socket connection associated with the user.
     */
    public void addUser(String name, Socket s)
    {
        userMap.put(name, s);
    }

    public Map<String, Socket> getUsers()
    {
        return userMap;
    }

    /**
     * Takes a message and sends it to every client that is connected to the server.
     *
     * @param message The message to be sent to each client.
     */
    public void broadcast(String message) throws IOException
    {
        for (Socket connection : userMap.values())
        {
            sendClient(
                    new PrintWriter(connection.getOutputStream(), true), message);
        }
    }

    /**
     * Sends a message directly to a client.
     *
     * @param output A PrintWriter object where the message will be written to.
     * @param message The message that is to be sent to the client.
     */
    public static void sendClient(PrintWriter output, String message)
    {
        output.println(message);
    }

    /**
     * Sends a message to client by finding the output stream from a username.
     *
     * @param username The username of the user that is to receive a message.
     * @param message The message that will be sent to the user.
     */
    public void sendClient(String username, String message) throws IOException
    {
        sendClient(
                new PrintWriter(
                        userMap.get(username).getOutputStream(), true), message);
    }
}