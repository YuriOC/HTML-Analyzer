import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HtmlFetcher {

    public BufferedReader fetch(String urlString) throws Exception{

        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        return new BufferedReader(
                new InputStreamReader(connection.getInputStream())
        );
    }

}
