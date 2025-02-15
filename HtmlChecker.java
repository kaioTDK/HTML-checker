import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class HtmlChecker {
    
    static private ArrayList<String> openedTags = new ArrayList<>();
    static private ArrayList<String> closedTags = new ArrayList<>();
    static private String buffLine = "";

    static public void htmlChecker(BufferedReader inputBuffer) throws IOException{
        HtmlTagsChecker(inputBuffer);
        if (openedTags.size() != closedTags.size()){
            System.out.println("malformed HTML");
            inputBuffer.reset();
            return;
        }
    }


    static private void HtmlTagsChecker(BufferedReader inputBuff) throws IOException{
        
        if ((buffLine = inputBuff.readLine()) == null){
            return;
        }
        buffLine.strip();
        if (buffLine.matches("<[a-z-A-Z-0-9- ]+>")){
            System.out.println(buffLine.substring(1, buffLine.length() - 1));
            openedTags.add(buffLine.substring(1, buffLine.length() - 1));
           
            HtmlTagsChecker(inputBuff);
        }
        else if (buffLine.matches("<[\\/][a-z-A-Z-0-9- ]+>") ){
            System.out.println(buffLine.substring(2, buffLine.length() - 1));
            closedTags.add(buffLine.substring(2, buffLine.length() - 1));
   
            HtmlTagsChecker(inputBuff);
        }

        HtmlTagsChecker(inputBuff);

    } 
    
}