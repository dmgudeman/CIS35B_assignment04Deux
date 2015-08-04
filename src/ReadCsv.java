
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
            while ((line = in.readLine()) != null) {responseData.add(line);}
            System.out.println("responseData.size() " + responseData.size());

            for (String l :  responseData)
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

     /*   try
        {
            PrintWriter writer = new PrintWriter(xmlFileWrittenTo);

            br = new BufferedReader(new FileReader(csvFileToRead));
            while ((line = br.readLine()) != null)
            {

                String[] cars = line.split(splitBy);
                System.out.println("<car>" + "\n\t<year>" + cars[0] + "</year>\n\t<make>"
                        + cars[1] + "</make>\n\t<model>" + cars[2] + "</model>\n\t<description>"
                        + cars[3] + "</description>\n\t<price>" + cars[4] + "</price>\n</car>");
                writer.println("<car>" + "\n\t<year>" + cars[0] + "</year>\n\t<make>"
                        + cars[1] + "</make>\n\t<model>" + cars[2] + "</model>\n\t<description>"
                        + cars[3] + "</description>\n\t<price>" + cars[4] + "</price>\n</car>");
               // Gui.TA_outputContent.append("<car>" + "\n\t<year>" + cars[0] + "</year>\n\t<make>"
              //          + cars[1] + "</make>\n\t<model>" + cars[2] + "</model>\n\t<description>"
                //        + cars[3] + "</description>\n\t<price>" + cars[4] + "</price>\n</car>");


            }


            writer.close();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            if (br != null)
            {
                try
                {
                    br.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
*/
        System.out.println("Done with reading CSV");
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

