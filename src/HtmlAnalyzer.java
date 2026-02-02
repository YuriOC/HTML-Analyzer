import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HtmlAnalyzer {
    public static void main(String[] args) {
        if(args.length == 0){
            System.out.println("error 1");
            return;
        }
        System.out.println("received: " + args[0]);
        String urlString = args[0];

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()){
                    continue;
                }
                if(line.startsWith("<") && !line.startsWith("</")){
                    System.out.println(line + " -> opening tag");
                } else if (line.startsWith("</")) {
                    System.out.println(line + " -> closing tag");
                } else {
                    System.out.println(line + " -> text");
                }
            }

            reader.close();

        } catch (Exception e) {
            System.out.println("URL connection error");
        }
    }
}
