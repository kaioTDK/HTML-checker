import java.net.URISyntaxException;

public class Html {
    
    private String[] html ;
    private  int i = 0;
    
    public Html(String htmlURL, VerboseFlag verbose) throws URISyntaxException{
        if(verbose == VerboseFlag.verbose) System.out.println("\nConnecting to URL and caching HTML...");
        html = HtmlCon.getHtml(htmlURL);
    }
    
    public String readLine(){
        if (i >= html.length) {
            return null;
        }
        String line = html[i];
        i +=1;
        if (line != null) return line;
        return null;
    }

    public boolean isEnd(){
        if (i >= html.length) return true;
        return false;
    }
    
    public  void reset(){
        i = 0;
    }
}