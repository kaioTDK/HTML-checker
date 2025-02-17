import java.net.*;
import java.io.*;

public class HtmlAnalyzer {
 
     public static void main (String[] args) throws Exception{
      
      //"http://hiring.axreng.com/internship/example1.html"
      //"http://localhost:8000")
          Html html = new Html("http://localhost:8000");
     
          HtmlReader.htmlReader(html, isVerbose.verbose);

     }
}