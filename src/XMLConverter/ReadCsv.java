package XMLConverter;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nagesh Chauhan
 */

public class ReadCsv
{
    public void readCsv(Socket socket)
    {
        //  String csvFileToRead = ServerGui.TF_inputFilename.getText();
        //  String csvFileToRead = "/Users/davidgudeman/Documents/workspace/CIS35B_assignment04/CTStest.csv";
        //   String xmlFileWrittenTo = "/Users/davidgudeman/Documents/workspace/CIS35B_assignment04/CTStest-down-xml.csv";
        //    BufferedReader br = null;
        String line = "";
        //   String splitBy = ",";

        try
        {
///////////////////////READCSV//////////////////////////////////////////////////////
            // Decorate the streams so we can send characters
            // and not just bytes.  Ensure output is flushed
            // after every newline.
       /*     String str="";
            StringBuffer buf = new StringBuffer();

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            InputStream is = socket.getInputStream();

            List<String> responseData = new ArrayList<String>();
            String lines;
            try {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(is));

                    while ((str = in.readLine()) != null) {
                        responseData.add(str);
                        //buf.append(str + "\n" );
                    }
                    */
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);


            List<String> responseData = new ArrayList<String>();
            while ((line = in.readLine()) != null)
            {
                responseData.add(line);
            }
            System.out.println("responseData.size() " + responseData.size());

            for (String l : responseData)
            {
                ServerGui.TA_inputContent.append(l);
                System.out.println(l);
                System.out.println("THIS FIRED");
            }


        } catch (IOException e)
        {
            System.out.println("ERROR");
        } finally
        {
            try
            {
                socket.close();
            } catch (IOException e)
            {
                log("Couldn't close a socket, what's going on?");
            }
            log("Connection with client# " + " closed");
        }
    }

    public void convertXML(Socket socket)
    {

    try

    {
        //  BufferedReader br;
        String[] words;
        String[] lines = new String[9];
        String[][] master = new String[9][5];
        //ArrayList<String[]> words = new ArrayList<>();
        System.out.println("lines.length "+ lines.length);
        lines = (ServerGui.TA_inputContent.getText().split("\n"));
        System.out.println("lines.length "+ lines.length);
        for (int j =0; j < lines.length; j++)
        {
            words = (lines[j].split(","));
            master[j]= words;
        }
        //   PrintWriter writer = new PrintWriter(xmlFileWrittenTo);
        //  Reader reader = new PrintStream()
        // br = new BufferedReader(ServerGui.TA_inputContent.getText());

        for (int i =0; i < master.length; i++)
        {
            System.out.println("<car>" + "\n\t<year>" + master[i][0] + "</year>\n\t<make>"
                    + master[i][1]+ "</make>\n\t<model>" + master[i][2] + "</model>\n\t<description>"
                    + master[i][3] + "</description>\n\t<price>" + master[i][4] + "</price>\n</car>");

            //      writer.println("<car>" + "\n\t<year>" + cars[0] + "</year>\n\t<make>"
            //         + cars[1] + "</make>\n\t<model>" + cars[2] + "</model>\n\t<description>"
            //          + cars[3] + "</description>\n\t<price>" + cars[4] + "</price>\n</car>");
            //
            //
            ServerGui.TA_outputContent.append("<car>" + "\n\t<year>" + master[i][0] + "</year>\n\t<make>"
                    + master[i][1]+ "</make>\n\t<model>" + master[i][2] + "</model>\n\t<description>"
                    + master[i][3] + "</description>\n\t<price>" + master[i][4] + "</price>\n</car>\n");

            //   PrintWriter out = new PrintWriter(ConverterClient.getSocket().getOutputStream(), true);
            //  out.println(XMLConverter.ClientGui.TA_inputContent.getText());
            //    System.out.println("XMLConverter.ClientGui.TA_inputContent " + XMLConverter.ClientGui.TA_inputContent.getText());
            //   out.close();


        }


        // writer.close();
        //   } catch (FileNotFoundException e)
        //   {
        //     e.printStackTrace();
        //    } catch (IOException e)
        //   {
        //        e.printStackTrace();
        //   } finally
        //   {
        //  if (br != null)
        //    {
        //      try
        //        {
        //
        // }       br.close();

    }

    catch(Exception e)
    {
        e.printStackTrace();
    }
    //       }
    //  }

    // System.out.println("Done with reading CSV");

}

    /**
     * Logs a simple message.  In this case we just write the
     * message to the server applications standard output.
     */
    private void log(String message)
    {
        System.out.println(message);
    }
}

