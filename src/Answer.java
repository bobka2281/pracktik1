import com.google.gson.Gson;
public class Answer {
    public static class SearchRes {
        Query query;
    }
    public static class Query {
        SearchItem[] search;
    }
    public static class SearchItem {
        String title;
        String snippet;
        int pageid;
        public String clean() {
            return snippet.replaceAll("<.*?>", "");
        }

        public String getUrl() {
            return "https://ru.wikipedia.org/w/index.php?curid=" + pageid;
        }
    }
    public SearchRes parse(String resp) {
        Gson gson = new Gson();
        return gson.fromJson(resp, SearchRes.class);
    }
    public void printRes(SearchRes result) {
        System.out.println("\nНайденные статьи:");
        for (int i = 0; i < result.query.search.length; i++) {
            SearchItem item = result.query.search[i];
            System.out.println((i + 1) + ". " + item.title);
            System.out.println("   " + item.clean());
        }
    }
}
