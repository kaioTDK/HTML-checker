import java.net.*;
import java.io.*;

public class HtmlAnalyzer {
 
     public static void main (String[] args) throws Exception{
            
        String message = "";
        int depth = 0;

        URI uri = new URI(args[0]);
        URL url = uri.toURL();
        BufferedReader  inputBuffer = new BufferedReader(new InputStreamReader(url.openStream()));
        String inputLine = "";
        

        HtmlReader.htmlReader(inputBuffer);
     }
}