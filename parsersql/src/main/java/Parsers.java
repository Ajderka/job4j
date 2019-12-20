import model.Months;
import model.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import storesql.Config;

import javax.management.StandardEmitterMBean;
import javax.xml.crypto.Data;
import java.net.URL;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Parsers implements Parser {

    private static final Logger LOG = LoggerFactory.getLogger(Parsers.class.getName());
    private Connection connection;
    private List<Vacancy> vacancies = new ArrayList<>();
    private Configurator config;

    public Parsers(Configurator config) {
        this.config = config;
    }

    private static Document getPage() throws Exception {
        String url = "https://www.sql.ru/forum/job-offers";
        return Jsoup.parse(new URL(url), 3000);
    }

    @Override
    public void parsPages() {
        try {
            Document page = getPage();
            Element tableFirst = page.select("table.forumTable").first();
            Elements models = tableFirst.select("td.postslisttopic");
            for (Element element : models) {
                String title = element.child(0).text();
                String url = element.select("a").attr("href");
                if (verificationJava(title)) {
                    Element Info = Jsoup.connect(url).get().selectFirst("table.msgTable");
                    Element description = Info.select("td.msgBody").get(1);
                    String data = Info.select("td.msgFooter").first().text();
                    vacancies.add(new Vacancy(title, description.text(), url, formatStringToDate(data)));
                }
            }
            vacancies.forEach(System.out::println);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }

    private void createTable() {
        String sql = "CREATE TABLE if not exists vacancies ("
                + "id serial primary key"
                + ",name varchar(255) UNIQUE not null"
                + ",description text"
                + ",link text"
                + ",data timestamp)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    private void insertInTable(Vacancy vacancy) {
        String sql = "INSERT INTO vacancies (name, description, link, date) Values (?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, vacancy.getName());
            preparedStatement.setString(2, vacancy.getText());
            preparedStatement.setString(3, vacancy.getLink());
            preparedStatement.setDate(4, (java.sql.Date) vacancy.getDate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    private Date formatStringToDate(String string) throws ParseException {
        String[] splitString = string.split(" ");
        int numberOfMonths = Months.valueOf(splitString[1].toUpperCase()).getNumber();
        String asd = splitString[0] + numberOfMonths + splitString[2];
        SimpleDateFormat format = new SimpleDateFormat("ddMMyy");
        Date docDate = format.parse(asd);
        return docDate;
    }

    public static void main(String[] args) throws Exception {
        Configurator configurator = new Configurator();
        configurator.getProperties("app.properties");
        Parsers parsers = new Parsers(configurator);
        parsers.initConnection();
        parsers.parsPages();
        parsers.createTable();
        parsers.vacancies.forEach(vacancy -> parsers.insertInTable(vacancy));

    }

    public void initConnection() {
        try {
            Connection conn = DriverManager.getConnection(config.get("url"), config.get("username"), config.get("password"));
            if (conn != null) {
                this.connection = conn;
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    private boolean verificationJava(String string) {
        return string.toLowerCase().contains("java") && !string.toLowerCase().contains("javascript")
                && !string.toLowerCase().contains("java script");
    }

    @Override
    public void close() throws Exception {
        if (this.connection != null) {
            connection.close();
        }
    }
}
