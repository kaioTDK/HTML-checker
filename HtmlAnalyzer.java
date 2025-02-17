import java.net.*;
import java.io.*;

public class HtmlAnalyzer {
 
     public static void main (String[] args) throws Exception{
      
      //"http://hiring.axreng.com/internship/example1.html"
      //"http://localhost:8000")
           switch (args[0]) {
               case "-v":
               case "--verbose":

                    Html html = new Html(args[0+1]);
                    HtmlReader.htmlReader(html, VerboseFlag.verbose);

                    break;
               
               default:
                     html = new Html(args[0]);
                    HtmlReader.htmlReader(html, VerboseFlag.verbose);
                    break;
           }
          
     

     }
}