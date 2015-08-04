package XMLConverter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * A server program which accepts requests from clients to
 * capitalize strings.  When clients connect, a new thread is
 * started to handle an interactive dialog in which the client
 * sends in a string and the server thread sends back the
 * capitalized version of the string.
 *
 * The program is runs in an infinite loop, so shutdown in platform
 * dependent.  If you ran it from a console window with the "java"
 * interpreter, Ctrl+C generally will shut it down.
 */
public class ConverterServer
{

    public static InetAddress ip;
    public static String ipAddress;
    public static String hostname;
    public static int PORT;
    public static ServerGui serverGui = new ServerGui();
    public static Socket socket;
    /**
     * Application method to run the server runs in an infinite loop
     * listening on port 9898.  When a connection is requested, it
     * spawns a new thread to do the servicing and immediately returns
     * to listening.  The server keeps a unique client number for each
     * client that connects just to show interesting logging
     * messages.  It is certainly not necessary to do this.
     */
    public static void main(String[] args) throws Exception {
        PORT = 9898;

        serverGui.TF_status.setText("The server is running.");

        ip = InetAddress.getLocalHost();
        ipAddress = ip.getHostAddress();
        hostname = ip.getHostName();
        serverGui.TF_port.setText(""+ PORT);
        serverGui.TF_hostname.setText(hostname);
        serverGui.TF_IPaddress.setText(ipAddress);

        int clientNumber = 0;
        ServerSocket listener = new ServerSocket(PORT);
        getIPHostname();
        try {
            while (true) {
                new Converter(listener.accept(), clientNumber++).start();

            }
        } finally {
            listener.close();
        }
    }

    /**
     * A private thread to handle capitalization requests on a particular
     * socket.  The client terminates the dialogue by sending a single line
     * containing only a period.
     */
    private static class Converter extends Thread
    {
        private int clientNumber;

        public Converter(Socket socket, int clientNumber) {
            ConverterServer.socket = socket;
            this.clientNumber = clientNumber;
            log("New connection with client# " + clientNumber + " at " + socket);
        }

        /**
         * Services this thread's client by first sending the
         * client a welcome message then repeatedly reading strings
         * and sending back the capitalized version of the string.
         */
        public void run() {
            try {
///////////////////////SERVER//////////////////////////////////////////////////////
                // Decorate the streams so we can send characters
                // and not just bytes.  Ensure output is flushed
                // after every newline.
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                String line;

                List<String> responseData = new ArrayList<String>();
                while ((line = in.readLine()) != null) {responseData.add(line);}
                System.out.println("responseData.size() " + responseData.size());

                for (String l :  responseData)
                {
                    serverGui.TA_inputContent.append(l + "\n");
                    System.out.println(l);
                    System.out.println("THIS FIRED");
                }

            } catch (Exception e) {
                log("Error handling client# " + clientNumber + ": " + e);
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    log("Couldn't close a socket, what's going on?");
                }
                log("Connection with client# " + clientNumber + " closed");
            }


        }
        public static Socket getSocket()
        {
            return socket;
        }

        /**
         * Logs a simple message.  In this case we just write the
         * message to the server applications standard output.
         */
        private void log(String message) {
            System.out.println(message);
        }
    }

    public static Socket getSocket()
    {
        return socket;
    }

    static public void getIPHostname()
    {
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

}
