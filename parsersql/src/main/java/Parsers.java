import model.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Parsers {

    private static Document getPage() throws Exception {
        String url = "https://www.sql.ru/forum/job-offers";
        Document page = Jsoup.parse(new URL(url), 3000);
        return page;
    }

    public static void main(String[] args) throws Exception {
        List<Vacancy> vacancies = new ArrayList<>();
        Document page = getPage();
        Element tableFirst = page.select("table[class=forumTable]").first();
        Elements models = tableFirst.select("td[class=postslisttopic]");

        for (Element element : models) {
            String name = element.child(0).text();
            String url = element.select("a").attr("href");
            Document pageText = Jsoup.parse(new URL(url), 1000);
            Element textEl = tableFirst.select("td[class=msgBody]").first();
            if (name.toLowerCase().contains("java")) {
                vacancies.add(new Vacancy(name, url));
            }
        }
        vacancies.forEach(System.out::println);

        for (Vacancy vacancy : vacancies) {

        }
    }
}
