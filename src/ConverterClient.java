
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

import javax.swing.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * A simple Swing-based client for the capitalization server.
 * It has a main frame window with a text field for entering
 * strings and a textarea to see the results of capitalizing
 * them.
 */
public class ConverterClient {

    private static BufferedReader in;
    private static PrintWriter out;

    public static final int PORT = 9898;
    public static final int BUFFER_SIZE = 100;
    public static String FILE_TO_SEND;
    public static Socket socket;




    /**
     * Implements the connection logic by prompting the end user for
     * the server's IP address, connecting, setting up streams, and
     * consuming the welcome messages from the server.  The Capitalizer
     * protocol says that the server sends three lines of text to the
     * client immediately after establishing a connection.
     */
    public void connectToServer() throws IOException {
        Thread thread = Thread.currentThread();
        ClientGui clientGui = new ClientGui();
        // Get the server address from a dialog box.
       // String serverAddress = clientGui.TF_inputFilename.getText();

        // Make connection and initialize streams
        socket = new Socket("localhost", PORT);
        in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        System.out.println("CTSClient SwingUtilities.isEventDispatchThread(): " + SwingUtilities.isEventDispatchThread());
        System.out.println("RunnableJob is being run by " + thread.getName() + " (" + thread.getId() + ")");
        }
    public static Socket getSocket()
    {
        return socket;
    }
    static public void CrunchifyGetIPHostname() {
            InetAddress ip;
            String hostname;
            try {
                ip = InetAddress.getLocalHost();
                hostname = ip.getHostName();
                System.out.println("Your current IP address : " + ip);
                System.out.println("Your current Hostname : " + hostname);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
    static public void work(Socket socket, String sfile) throws IOException
    {
        File file = new File(sfile);
       // ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
      //  ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());


        out.print(file);


        out.close();
        in.close();
        System.exit(0);
    }
    /**
     * Runs the client application.
     */
    public static void main(String[] args) throws Exception {
        ConverterClient client = new ConverterClient();

        client.connectToServer();

    }
}