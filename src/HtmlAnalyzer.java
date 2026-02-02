public class HtmlAnalyzer {
    public static void main(String[] args) {
        if(args.length == 0){
            System.out.println("URL connection error");
            return;
        }

        System.out.println("received: " + args[0]);
    }
}
