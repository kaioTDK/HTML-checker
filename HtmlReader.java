import java.io.*;

public class HtmlReader {

    static private int depth = 0;
    static private int maxDepth = 0;
    static private String message = "";
    static private String htmlLine = "";

    public static void htmlReader(Html html, VerboseFlag verboseFlag) throws IOException{
        if (verboseFlag == VerboseFlag.verbose) System.out.println("\nCalling html checker:");
        HtmlChecker.htmlChecker(html, verboseFlag);
        if (verboseFlag == VerboseFlag.verbose) System.out.println("\nCalling html reader:\n");
        htmlReader(html, depth, maxDepth, message, verboseFlag);
    }

    private static void htmlReader(Html html,int depth, int maxDepth, String message, VerboseFlag verboseFlag) throws IOException{

        switch (verboseFlag) {
            case verbose:
                if ((htmlLine = html.readLine()) == null ){
                    System.out.println("\nMessage: " + message);
                    System.out.println("depth: " + maxDepth);
                    return;
                }
                    System.out.println("HTML line:" + htmlLine);
                break;
            case noVerbose:
                if ((htmlLine = html.readLine()) == null ) {
                     System.out.println(message);
                    return;
                }
                break;
            default:
                break;
        }
        
        if (htmlLine.trim().matches("<[a-z-A-Z-0-9- ]+>")){
            htmlReader(html, depth + 1, maxDepth, message, verboseFlag);
        }
        else if (htmlLine.trim().matches("<[\\/][a-z-A-Z-0-9- ]+>") ){
            htmlReader(html, depth - 1, maxDepth, message, verboseFlag);
        }
        else if (!htmlLine.matches("<([^<]+)>") & depth > maxDepth & !htmlLine.isEmpty()){
            message = htmlLine.trim();
            htmlReader(html, depth, depth, message, verboseFlag);
        }
        else{
            htmlReader(html, depth, maxDepth, message, verboseFlag);
        }
    }
}