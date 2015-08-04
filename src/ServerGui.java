import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by davidgudeman on 8/1/15.
 */
public class ServerGui
{
    public static JFrame MainWindow;
    public static JPanel panel;

    public static JLabel JL_TITLE = null;
    public static JLabel JL_subTitle = null;
    public static JLabel JL_subTitle2 = null;

    public static JLabel JL_status = null;
    public static JTextField TF_status = null;

    public static JLabel JL_port = null;
    public static JTextField TF_port = null;

    public static JLabel JL_IPaddress = null;
    public static JTextField TF_IPaddress = null;

    public static JLabel JL_hostname = null;
    public static JTextField TF_hostname = null;

    public static JLabel JL_input = null;
    public static JTextField TF_inputFilename = null;
    public static JTextArea TA_inputContent = null;
    public static JScrollPane JSP_pane  = null;

    public static JLabel JL_output = null;
    public static JTextField TF_outputFileName = null;
    public static JTextArea TA_outputContent = null;
    public static JScrollPane JSP_pane2  = null;

    public static JLabel JL_convertButton = null;
    public static JButton JB_convertButton = null;

    public ServerGui()
    {
        BuildGui();
      /*  Runnable code = new Runnable()
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
            */
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
        panel.setSize(600,1200);
        Color dirtyBrown = new Color(93, 25, 25, 150);
        Color purpleDark = new Color(50, 50, 50, 150);
        panel.setBackground(dirtyBrown);

        // declares the elements in the frame DG
        JL_TITLE = new JLabel("SERVER");
        JL_TITLE.setFont(new Font("Geneva", Font.ROMAN_BASELINE, 45));

        JL_status= new JLabel("SERVER STATUS: ");
        TF_status = new JTextField(200);

        JL_port = new JLabel("PORT: ");
        TF_port = new JTextField(200);

        JL_IPaddress = new JLabel("ip Adress: ");
        TF_IPaddress = new JTextField(200);

        JL_hostname = new JLabel("hostname: ");
        TF_hostname = new JTextField(200);

        JL_subTitle = new JLabel("INCOMING FILE");
        JL_subTitle.setFont(new Font("Geneva", Font.ROMAN_BASELINE, 25));
        JL_subTitle.setBackground(purpleDark);

        JL_input = new JLabel("RECEIVED FILENAME: ");
        TF_inputFilename = new JTextField(15);

        TA_inputContent = new JTextArea(600, 600);
        TA_inputContent.setLineWrap(true);
        TA_inputContent.setPreferredSize(new Dimension(600, 600));

        JSP_pane = new JScrollPane(TA_inputContent, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        JSP_pane.setPreferredSize(new Dimension(600, 600));

        JL_convertButton = new JLabel("CONVERT:");
        JB_convertButton = new JButton("convert");

        JL_subTitle2 = new JLabel("CONVERTED FILE");
        JL_subTitle2.setFont(new Font("Geneva", Font.ROMAN_BASELINE, 15));
        JL_subTitle2.setBackground(purpleDark);

        JL_output = new JLabel("OUTPUT FILENAME: ");
        TF_outputFileName = new JTextField(15);
        TA_outputContent = new JTextArea(600, 600);

        JSP_pane2 = new JScrollPane(TA_outputContent, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        JSP_pane2.setPreferredSize(new Dimension(600, 600));

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

        c.anchor = GridBagConstraints.WEST;
        c.gridx = 0;
        c.gridy = 1;
        c.weighty = 0;
        c.gridwidth = 1;
        panel.add(JL_status, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 1;
        c.ipadx= 200;
        c.gridwidth = 3;
        panel.add(TF_status, c);

       // c.anchor = GridBagConstraints.WEST;
        c.gridx = 0;
        c.gridy = 2;
        c.weighty = 0;
        c.gridwidth = 1;
        panel.add(JL_port, c);

       // c.fill = GridBagConstraints.HORIZONTAL;
      //  c.anchor = GridBagConstraints.WEST;
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 3;
        panel.add(TF_port, c);

        c.gridx = 0;
        c.gridy = 3;
        c.weighty = 0;
        c.gridwidth = 1;
        panel.add(JL_hostname, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 3;
        panel.add(TF_hostname, c);


      //  c.anchor = GridBagConstraints.WEST;
        c.gridx = 0;
        c.gridy = 4;
        c.weighty = 0;
        c.gridwidth = 1;
        panel.add(JL_IPaddress, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 1;
        c.gridy = 4;
        c.gridwidth = 3;
        panel.add(TF_IPaddress, c);


        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.NONE;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 4;
        panel.add(JL_subTitle, c);


        c.anchor = GridBagConstraints.WEST;
        c.gridx = 0;
        c.gridy = 6;
        c.weighty = 0;
        c.gridwidth = 1;
        panel.add(JL_input, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 1;
        c.gridy = 6;
        c.gridwidth = 3;
        panel.add(TF_inputFilename, c);

        c.gridx = 0;
        c.gridy = 7;
        c.gridwidth = 4;
        c.ipady = 200;
        c.fill = GridBagConstraints.HORIZONTAL;
        panel.add(JSP_pane, c);


        c.gridx = 0;
        c.gridy = 8;
        c.ipady = 0;
        panel.add(JB_convertButton, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 9;
        c.gridwidth = 4;
        panel.add(JL_subTitle2, c);

        c.gridx = 0;
        c.gridy = 10;
        c.gridwidth = 1;
        panel.add(JL_output, c);

        c.gridx = 1;
        c.gridy = 10;
        c.gridwidth = 3;
        panel.add(TF_outputFileName, c);

        c.gridwidth = 4;
        c.gridx = 0;
        c.gridy = 11;
        c.ipady = 200;
        panel.add(JSP_pane2, c);

        MainWindow.add(panel, BorderLayout.CENTER);

        MainWindow.setVisible(true);

        // ActionListener added to NEXT button
        JB_convertButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                EventQueue.invokeLater(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        ReadCsv r = new ReadCsv();
                        r.convertXML(ConverterServer.getSocket());
                    }
                });
            }
        });


        // ActionListener added to PREV button
  /*      JB_chooseFile.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                java.awt.EventQueue.invokeLater(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        try
                        {
                            JB_inputActionPerformed();
                        }
                        catch (IOException f)
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
        JFileChooser chooser = new JFileChooser("/Users/davidgudeman/Documents/workspace/CIS35B_assignment04");
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
        */
    }

   

}
