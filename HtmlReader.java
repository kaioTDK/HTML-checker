import java.io.*;

public class HtmlReader {

    static private int depth = 0;
    static private int maxDepth = 0;
    static private String message = "";
    static private String buffLine = "";
    static private isVerbose verbose = isVerbose.noVerbose;

    public static void htmlReader(Html inputBuff) throws IOException{
       // HtmlChecker.htmlChecker(inputBuff);
        htmlReader(inputBuff, depth, maxDepth, message);
        
    }
    public static void htmlReader(Html inputBuff, isVerbose verboseFlag) throws IOException{
        HtmlChecker.htmlChecker(inputBuff);
        verbose = verboseFlag;
        htmlReader(inputBuff, depth, maxDepth, message);
    }

    private static void htmlReader(Html inputBuff,int depth, int maxDepth, String message) throws IOException{

        switch (verbose) {
            case verbose:
                if ((buffLine = inputBuff.readLine()) == null ){
                    System.out.println(message);
                    System.out.println(maxDepth);
                    return;
                }
                    System.out.println("i'm at line:" + buffLine);
                break;
            case noVerbose:
                if ((buffLine = inputBuff.readLine()) == null ) {
                     System.out.println(message);
                    return;
                }
                    break;
            default:
                break;
        }
        
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