public class Html {
    
    private static String[] html;
    private static int i = 0;
    
    public Html(String htmlURL){
        html = HtmlCon.getHtml(htmlURL);
    }

    public static String readLine(){
        String line = html[i];
        i +=1;
        return line;
    }
    
    public static void reset(){
        i = 0;
    }
}
