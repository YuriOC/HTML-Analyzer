import java.io.BufferedReader;

public class HtmlAnalyzer {
    public static void main(String[] args) {

        try {
            HtmlFetcher fetcher = new HtmlFetcher();
            HtmlLineProcessor processor = new HtmlLineProcessor();
            BufferedReader reader = fetcher.fetch(args[0]);

            String line;
            while((line = reader.readLine()) != null){
                processor.ReadHTMLContentLines(line);
            }

            reader.close();
            System.out.println(processor.getText());

        } catch (Exception e) {
            System.out.println("URL connection error");
        }
    }
}
