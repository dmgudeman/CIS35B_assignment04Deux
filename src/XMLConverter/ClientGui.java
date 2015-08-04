package XMLConverter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

/**
 * Created by davidgudeman on 8/1/15.
 */
public class ClientGui
{
    private BufferedReader in;
    private PrintWriter out;
    public static JFrame MainWindow;
    public static JPanel panel;

    public static JLabel JL_TITLE = null;
    public static JLabel JL_subTitle = null;
    public static JLabel JL_subTitle2 = null;

    public static JButton JB_chooseFile = null;
    public static JLabel JL_input = null;
    public static JTextField TF_inputFilename = null;
    public static JTextArea TA_inputContent = null;
    public static JScrollPane JSP_pane  = null;

    public static JLabel JL_output = null;
    public static JTextField TF_outputFileName = null;
    public static JTextArea TA_outputContent = null;

    public static JLabel JL_port = null;
    public static JTextField TF_port = null;

    public static JButton JB_sendFileButton = null;
    public static JLabel JL_convertButton = null;
    public static JButton JB_convertButton = null;

    public ClientGui()
    {
        Runnable code = new Runnable()
        {
            public void run()
            {
                System.out.println("BEFORE SwingUtilities.isEventDispatchThread(): " + SwingUtilities.isEventDispatchThread());
                BuildGui();
                System.out.println("AFTER SwingUtilities.isEventDispatchThread(): " + SwingUtilities.isEventDispatchThread());
            }};
            if (SwingUtilities.isEventDispatchThread())

            {
                System.out.println("SwingUtilities.isEventDispatchThread(): " + SwingUtilities.isEventDispatchThread());
                code.run();
            }else{
                SwingUtilities.invokeLater(code);
            }

        }


    public void BuildGui()
    {
        MainWindow = new JFrame();
        MainWindow.setSize(700, 1300);
        MainWindow.setTitle("CSV to XML CONVERTER");
        MainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel(new GridBagLayout());

        // creates panel DG
        panel = new JPanel(new GridBagLayout());
        panel.setSize(600, 1200);
        Color purpleMedium = new Color(93, 119, 178, 150);
        Color purpleDark = new Color(50, 50, 50, 150);
        panel.setBackground(purpleMedium);

        // declares the elements in the frame DG
        JL_TITLE = new JLabel("CLIENT");
        JL_TITLE.setFont(new Font("Geneva", Font.ROMAN_BASELINE, 30));

        JL_subTitle = new JLabel("FILE TO BE CONVERTED");
        JL_subTitle.setFont(new Font("Geneva", Font.ROMAN_BASELINE, 15));
        JL_subTitle.setBackground(purpleDark);

        JB_chooseFile = new JButton("CHOOSE FILE");
        JL_input = new JLabel("INPUT FILENAME: ");
        TF_inputFilename = new JTextField(15);
        TA_inputContent = new JTextArea(600, 600);
        TA_inputContent.setLineWrap(true);
        TA_inputContent.setPreferredSize(new Dimension(600, 600));
        JSP_pane = new JScrollPane(TA_inputContent, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JSP_pane.setPreferredSize(new Dimension(600, 600));

        JL_port = new JLabel("PORT: ");
        TF_port = new JTextField(25);

        JB_sendFileButton = new JButton("SENDFILE");

        // JL_convertButton = new JLabel("CONVERT:");
        // JB_convertButton = new JButton("convert");

        JL_subTitle2 = new JLabel("CONVERTED FILE");
        JL_subTitle2.setFont(new Font("Geneva", Font.ROMAN_BASELINE, 15));
        JL_subTitle2.setBackground(purpleDark);

        JL_output = new JLabel("OUTPUT FILENAME: ");
        TF_outputFileName = new JTextField(15);
        TA_outputContent = new JTextArea(25, 50);

        /**
         * Uses Layout tool to position the elements in the panel Gudeman
         */
        // creates an object to hold the gridBaglayout constraints DG
        GridBagConstraints c = new GridBagConstraints();

        // sets the distance between elements DG
        c.insets = new Insets(5, 15, 5, 15);

        // use GridBagLayout specifications to position the components DG

        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 4;
        panel.add(JL_TITLE, c);

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 4;
        panel.add(JL_subTitle, c);

        c.anchor = GridBagConstraints.WEST;
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        panel.add(JB_chooseFile, c);


        c.gridx = 0;
        c.gridy = 3;
        c.weighty = 0;
        c.gridwidth = 1;
        panel.add(JL_input, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 3;
        c.weighty = 1;
        c.gridwidth = 3;
        panel.add(TF_inputFilename, c);

        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 4;
        c.ipady = 200;
        c.fill = GridBagConstraints.HORIZONTAL;
        panel.add(JSP_pane, c);

        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 5;
        c.ipady = 0;
        c.gridwidth = 1;
        panel.add(JB_sendFileButton, c);

 /*       c.anchor = GridBagConstraints.WEST;
        c.gridx = 1;
        c.gridy = 5;
        panel.add(TF_port, c);
/*
        c.gridx = 2;
        c.gridy = 5;
        panel.add(JL_convertButton, c);

        c.gridx = 3;
        c.gridy = 5;
        panel.add(JB_convertButton, c);
*/
        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 4;
        panel.add(JL_subTitle2, c);

        c.gridx = 0;
        c.gridy = 7;
        c.gridwidth = 1;
        panel.add(JL_output, c);

        c.gridx = 1;
        c.gridy = 7;
        c.gridwidth = 3;
        panel.add(TF_outputFileName, c);

        c.gridwidth = 4;
        c.gridx = 0;
        c.gridy = 8;
        c.ipady = 200;
        panel.add(TA_outputContent, c);

        MainWindow.add(panel, BorderLayout.CENTER);

        MainWindow.setVisible(true);

        // ActionListener added to NEXT button
        JB_sendFileButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                EventQueue.invokeLater(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        try
                        {
                            PrintWriter out = new PrintWriter(ConverterClient.getSocket().getOutputStream(), true);
                            out.println(ClientGui.TA_inputContent.getText());
                            System.out.println("XMLConverter.ClientGui.TA_inputContent " + ClientGui.TA_inputContent.getText());
                                  out.close();
                        }
                        catch (Exception e)
                        {
                            System.out.println(e);
                        }

                    }
                });
            }
        });



        // ActionListener added to PREV button
    JB_chooseFile.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                EventQueue.invokeLater(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        try
                        {
                            JB_inputActionPerformed();
                        } catch (IOException f)
                        {
                            JOptionPane.showMessageDialog(null, f);
                        }
                    }
                });
            }
        });
    }

    public void JB_inputActionPerformed() throws IOException
    {
        JFileChooser chooser = new JFileChooser("/Users/davidgudeman/Documents/workspace/CIS35B_assignment04Deux/src/XMLConverter");
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename = f.getAbsolutePath();
        TF_inputFilename.setText(filename);

        try
        {
            FileReader reader = new FileReader(filename);
            BufferedReader br = new BufferedReader(reader);
            TA_inputContent.read(br, null);
            br.close();
            TA_inputContent.requestFocus();
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    /**
     * Implements the connection logic by prompting the end user for
     * the server's IP address, connecting, setting up streams, and
     * consuming the welcome messages from the server.  The Capitalizer
     * protocol says that the server sends three lines of text to the
     * client immediately after establishing a connection.
     */
    public void connectToServer() throws IOException {

        // Get the server address from a dialog box.
        String serverAddress = JOptionPane.showInputDialog(MainWindow,
                "Enter IP Address of the Server:",
                "Welcome to the Capitalization Program",
                JOptionPane.QUESTION_MESSAGE);

        // Make connection and initialize streams
        Socket socket = new Socket(serverAddress, 9898);
        in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

        // Consume the initial welcoming messages from the server
        for (int i = 0; i < 3; i++) {
            TF_inputFilename.setText(in.readLine() + "\n");
        }
    }
   

}


/* java.awt.EventQueue.invokeLater(new Runnable()
                {
                    STCServer s = new STCServer();
                    @Override
                    public void run()
                    {
                        //s.runProgram();
                        try
                        {
                            CTSServer ctsServer = new CTSServer();
                        } catch (Exception e)
                        {
                            System.out.println("Exception caught");
                        }
                        new CTSClient().start();
                        Thread thread1 = new Thread(ctsClient);
                        System.out.println("JB_sendFileButton pressed");
                        thread1.setName("ctsClient");
                        thread1.start();



                });
            }
        });
*/