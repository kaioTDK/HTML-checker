import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

public class HtmlCon {
    static private String line = "";
    static private ArrayList<String> htmlTemp = new ArrayList<String>();
    static private String[] html;

    static public String[] getHtml(String args) throws URISyntaxException{
        
        try {
        URI uri = new URI(args);
        URL url = uri.toURL();
        BufferedReader inputBuffer = new BufferedReader(new InputStreamReader(url.openStream()));
        htmlReader(inputBuffer);
        html = htmlTemp.toArray(new String[0]);
        inputBuffer.close();
        
         
      } catch (IOException e) {
         System.err.println("URL connection error");
        // System.err.println(e.getMessage());
      }
      return html;
    }

    static private void htmlReader(BufferedReader inputBuff) throws IOException{
        if((line = inputBuff.readLine()) == null) return;
            htmlTemp.add(line);
            htmlReader(inputBuff);

    }
}
