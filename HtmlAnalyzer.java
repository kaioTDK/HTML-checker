import java.net.*;
import java.io.*;

public class HtmlAnalyzer {
 
     public static void main (String[] args) throws Exception{
            
        //URI uri = new URI(args[0]);
        URI uri = new URI("http://hiring.axreng.com/internship/example1.html");
        //URI uri = new URI("http://locahost:8000");
        URL url = uri.toURL();
        BufferedReader  inputBuffer = new BufferedReader(new InputStreamReader(url.openStream()));
        

        HtmlReader.htmlReader(inputBuffer,0,0, "");
     }
}