import java.io.*;

public abstract class HtmlReader {
    
    public static void htmlReader(BufferedReader inputBuff) throws IOException{
        String input = "";
        if ((input = inputBuff.readLine()) == null ){
            return;
        }
        System.out.println(input);
        htmlReader(inputBuff);
    }
}
