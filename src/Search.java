import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
public class Search {
    public String wiki(String query) throws IOException {
        String encode = URLEncoder.encode(query, "UTF-8");
        String urlStr =  "https://ru.wikipedia.org/w/api.php?action=query&list=search&srsearch=" + encode + "&format=json&utf8=1";
        URL url = new URL(urlStr);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)");
        BufferedReader reader = new BufferedReader( new InputStreamReader(con.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        con.disconnect();
        return response.toString();
    }
}
