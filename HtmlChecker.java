import java.util.ArrayList;

public class HtmlChecker {
    
    static private ArrayList<HtmlElement> openedTags = new ArrayList<>();
    static private ArrayList<HtmlElement> closedTags = new ArrayList<>();
    static private int depth = 0;
    static private String buffLine = "";

    static public void htmlChecker(Html html, VerboseFlag verboseFlag){
        htmlTagsChecker(html);
        if (openedTags.size() != closedTags.size()){
            System.err.println("malformed HTML");
            System.exit(0);
            return;
        }
        if(verboseFlag == VerboseFlag.verbose) System.out.println("Tags diff checked...\nCalling tag checker...");

        tagChecker(verboseFlag);
        html.reset();
        return;
    }

    static private void tagChecker(VerboseFlag verbose){   
        int i = 0;
        HtmlElement openElement = null;
        HtmlElement closedElement = null;

        if (verbose == VerboseFlag.verbose) System.out.println("\nStarted tag checker:\n");

        while ( i < openedTags.size()){        
            int j = 0;
            boolean isClosed = false;
            openElement = openedTags.get(i);

            while ( j < closedTags.size()){
                closedElement = closedTags.get(j);
                if(verbose == VerboseFlag.verbose){
                    System.out.println("opened element: "+ openElement.element()+ " " + openElement.depth());
                    System.out.println("closed element: " + closedElement.element()+ " " + closedElement.depth());
                    System.out.println("is equal: "+openElement.equals(closedElement)+"\n");
                }
                if (openElement.isEqual(closedElement)){
                    isClosed = true;
                    j += 1;
                    break;
                }
                j += 1;
            }
            if (!isClosed) {
                System.err.println("malformed HTML"); 
                System.exit(0);
            }
            i += 1;
        }
    }

    static private void htmlTagsChecker(Html inputBuff){
        
        if ((buffLine = inputBuff.readLine()) == null ) return;
        buffLine = buffLine.trim();
        if (buffLine.matches("<[a-z-A-Z-0-9- ]+>")){
            depth += 1;
            openedTags.add(new HtmlElement(buffLine.strip().substring(1, buffLine.length() - 1), depth));   
            htmlTagsChecker(inputBuff);
        }
        else if (buffLine.matches("<[\\/][a-z-A-Z-0-9- ]+>") ){
            closedTags.add(new HtmlElement(buffLine.strip().substring(2, buffLine.length() - 1), depth));
            depth -= 1;
            htmlTagsChecker(inputBuff);
        }
        htmlTagsChecker(inputBuff);
    } 
}

record HtmlElement(String element, int depth) {
    boolean isEqual(HtmlElement element){
        if (this.element().equals(element.element())  & this.depth() == element.depth()) return true;
        return false;
    }
}