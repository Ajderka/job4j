package jsoup;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HelloJsoup {

    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("http://sql.ru").get();
        String title = doc.title();
        System.out.println("Title:" + title);
    }
}
