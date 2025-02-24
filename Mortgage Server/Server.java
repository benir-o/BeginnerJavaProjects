import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Defines a server that spawns clients to find monthly morgage payments.
 *
 * @author Riley Simmons
 */
public class Server {

    private final static int maxClients = 10;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8000);

        for (int i = 0; i < maxClients; i++) {
            Socket client = server.accept();
            Thread clientThread = new HandleClient(client);
            clientThread.start();
        }
    }
}
