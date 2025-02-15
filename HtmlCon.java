import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

public class HtmlCon {
    static private String line = "";
    static private ArrayList<String> htmlTemp;
    static private String[] html;

    static public String[] getHtml(String args){
        
        try {
        //URI uri = new URI(args);
        URI uri = new URI("http://hiring.axreng.com/internship/example1.html");
        //URI uri = new URI("http://localhost:8000");
        URL url = uri.toURL();
        BufferedReader  inputBuffer = new BufferedReader(new InputStreamReader(url.openStream()))
        html = (String[]) htmlTemp.toArray();
        inputBuffer.close();
         
      } catch (IOException e) {
         System.err.println("URL connection error");
         System.err.println(e.getMessage());
      }
      return html;
    }

    static private void htmlReader(BufferedReader inputBuff) throws IOException{
        if((line = inputBuff.readLine()) == null) return;
            htmlTemp.add(line);
            htmlReader(inputBuff);
    }
}
