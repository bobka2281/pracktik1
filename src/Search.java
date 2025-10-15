import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
public class Search {
    private static final String link =
            "https://ru.wikipedia.org/w/api.php";
    private static final String user =
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64)";
    public String wiki(String query) throws Exception {
        String encodedQuery = URLEncoder.encode(query, "UTF-8");
        String urlString = link
                + "?action=query&list=search&srsearch="
                + encodedQuery
                + "&format=json&utf8=1";
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", user);
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