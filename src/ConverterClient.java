
import sun.nio.cs.US_ASCII;
import sun.nio.cs.ext.ISO_8859_11;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

import javax.swing.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.Charset;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple Swing-based client for the capitalization server.
 * It has a main frame window with a text field for entering
 * strings and a textarea to see the results of capitalizing
 * them.
 */
public class ConverterClient {

    private static BufferedReader in;
    private static FileInputStream fileInputStream;

    private static PrintWriter out;
    private static OutputStream outputStream;

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
    public static void work() throws IOException
    {
       // File file = new File(sfile);
       // ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
      //  ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
     /*   long length = file.length();
        byte[] bytes = new byte[16 * 1024];
        fileInputStream = new FileInputStream(file);

        outputStream = socket.getOutputStream();
        int count;
        while ((count = fileInputStream.read(bytes)) > 0)
        {
            outputStream.write(bytes, 0, count);
        }

        outputStream.close();
        fileInputStream.close();
        System.exit(0);
*/
        //Path absolute = Paths.get(sfile);
    //    Charset cset = Charset.defaultCharset().forName("ISO-8859-1");
     //   List<String> lines = Files.readAllLines(absolute, cset);
        outputStream = socket.getOutputStream();
        String response;

       // File inFile  = new File(sfile);
      //  BufferedReader in = new BufferedReader(new FileReader(sfile));
        PrintStream writer = new PrintStream(outputStream);
        List<String> TAlist = new ArrayList<>();
        for (String line : ClientGui.TA_inputContent.getText().split("\\n"))
        try
        {
            while (writer != null)
                writer.println(line);
            System.out.println(line);
        }
        catch (Exception ex)
        {
            System.out.println( "Error: " + ex);
        }
        writer.close();


    }
    /**
     * Runs the client application.
     */
    public static void main(String[] args) throws Exception {
        ConverterClient client = new ConverterClient();

        client.connectToServer();

    }
}