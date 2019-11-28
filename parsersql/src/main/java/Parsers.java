import model.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Parsers implements Parser {

    static final Logger LOG = LoggerFactory.getLogger(Parsers.class.getName());
    private Connection connection;

    private static Document getPage() throws Exception {
        String url = "https://www.sql.ru/forum/job-offers";
        Document page = Jsoup.parse(new URL(url), 3000);
        return page;
    }

    @Override
    public void parsPages() {
        try {
            List<Vacancy> vacancies = new ArrayList<>();
            Document page = getPage();
            Element tableFirst = page.select("table.forumTable").first();
            Elements models = tableFirst.select("td.postslisttopic");

            for (Element element : models) {
                String title = element.child(0).text();
                String url = element.select("a").attr("href");
                if (title.toLowerCase().contains("java")) {
                    Element data = Jsoup.connect(url).get().selectFirst("table.msgTable");
                    Element text = data.select("td.msgBody").get(1);
                    vacancies.add(new Vacancy(title, text.text(), url));
                }
            }
            vacancies.forEach(System.out::println);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }

    private void createTable () {
        String sql = "CREATE TABLE if not exists vacancies ("
                + "id serial primary key not null"
                + ",name varchar(255) UNIQUE not null"
                + ",description text"
                + ",link text)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    public static void main(String[] args) throws Exception {
        Parsers parsers = new Parsers();
        parsers.parsPages();
    }

    @Override
    public void close() throws Exception {
        if (this.connection != null) {
            connection.close();
        }
    }
}
