import java.io.*;

public class HtmlReader3 {
    static private int depth = 0;
    static private int maxDepth = 0;
    static private String message = "";
    static private String buffLine = "";

    public static void htmlReader(BufferedReader inputBuff) throws IOException{
        
        if ((buffLine = inputBuff.readLine()) == null ){
            System.out.println(message);
            System.out.println(maxDepth);
            return;
        }

        System.out.println("i'm at line:" + buffLine);
        
        if (buffLine.trim().matches("<[a-z-A-Z-0-9- ]+>")){       
            depth += 1;
            htmlReader(inputBuff);
        }
        else if (buffLine.trim().matches("<[\\/][a-z-A-Z-0-9- ]+>") ){
            depth -= 1;
            htmlReader(inputBuff);
        }
        else if (!buffLine.matches("<([^<]+)>") & depth > maxDepth & !buffLine.isEmpty()){
            message = buffLine.trim();
            maxDepth = depth;
            htmlReader(inputBuff);
        }
        else{
            htmlReader(inputBuff);
        }
    }
}