import java.net.*;
import java.io.*;

public class HtmlAnalyzer {
 
     public static void main (String[] args) throws Exception{
        
      
      try {
         //URI uri = new URI(args[0]);
        URI uri = new URI("http://hiring.axreng.com/internship/example1.html");
        URL url = uri.toURL();
        BufferedReader  inputBuffer = new BufferedReader(new InputStreamReader(url.openStream()));
        HtmlReader.htmlReader(inputBuffer,0,0, "");
        inputBuffer.close();
         
      } catch (IOException e) {
         System.err.println("URL connection error");
      }

     }
}