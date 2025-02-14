import java.io.*;

public class HtmlReader2 {

    static private int depth = 0;
    static private int maxDepth = 0;
    static private String message = "";
    static private String buffLine = "";

    public static void htmlReader(BufferedReader inputBuff) throws IOException{
        htmlReader(inputBuff, depth, maxDepth, message);
    }

    private static void htmlReader(BufferedReader inputBuff,int depth, int maxDepth, String message) throws IOException{

        if ((buffLine = inputBuff.readLine()) == null ){
            System.out.println(message);
            System.out.println(maxDepth);
            return;
        }
        System.out.println("i'm at line:" + buffLine);
        
        if (buffLine.trim().matches("<[a-z-A-Z-0-9- ]+>")){
            htmlReader(inputBuff, depth + 1, maxDepth, message);
        }
        else if (buffLine.trim().matches("<[\\/][a-z-A-Z-0-9- ]+>") ){
            htmlReader(inputBuff, depth - 1, maxDepth, message);
        }
        else if (!buffLine.matches("<([^<]+)>") & depth > maxDepth & !buffLine.isEmpty()){
            message = buffLine.trim();
            htmlReader(inputBuff, depth, depth, message);
        }
        else{
            htmlReader(inputBuff, depth, maxDepth, message);
        }
    }
}