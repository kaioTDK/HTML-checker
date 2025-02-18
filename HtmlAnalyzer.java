public class HtmlAnalyzer {
 
     public static void main (String[] args) throws Exception{
          
          if (args.length == 0) {
               System.err.println("please, use as: java HtmlAnalyzer [URL] or java HtmlAnalyzer -h to see help");
               System.exit(0);
          }
           switch (args[0]) {
               case "-v":
                    Html html = new Html(args[0+1], VerboseFlag.verbose);
                    HtmlReader.htmlReader(html, VerboseFlag.verbose);
                    break;
               case "-h":
                    if (args.length > 1) System.err.println("\n    *WARNING* -h must be the only argument!\n");
                    System.out.println("To use the program: java HtmlAnalyzer [options] [URL to HTML]");
                    System.out.println("The options are as follows: ");
                    System.out.println("-h: print this help message");
                    System.out.println("-v: verbose mode to see some steps of the execution, good for debuggin or just to see it working");
                    break;
               default:
                    html = new Html(args[0], VerboseFlag.noVerbose);
                    HtmlReader.htmlReader(html, VerboseFlag.noVerbose);
                    break;
           }
     }
}