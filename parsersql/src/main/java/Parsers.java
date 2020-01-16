import model.Months;
import model.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

/**
 * Class for working with database.
 * Parsers a list vacancies and stores them in database.
 */
public class Parsers implements Parser {

    /**
     * Logger for info output.
     */
    private static final Logger LOG = LoggerFactory.getLogger(Parsers.class.getName());

    /**
     * Connection to the database.
     */
    private Connection connection;

    /**
     * Loader properties with connection options.
     */
    private Properties properties;

    /**
     * HashSet to protection the database from duplicates.
     */
    private HashSet<String> checker;

    private List<Vacancy> vacancies = new ArrayList<>();
    private Configurator config;

    public Parsers(Configurator config) {
        this.config = config;
    }

    /**
     * Only for tests.
     * @param connection
     */
    public Parsers(Connection connection) {
        this.connection = connection;
    }

    public Parsers(Properties properties) {
        this.properties = properties;
    }

    private static Document getPage() throws Exception {
        String url = "https://www.sql.ru/forum/job-offers";
        return Jsoup.parse(new URL(url), 3000);
    }

    @Override
    public void parsPages() {
        try {
            Document page = getPage();
            LOG.info("Parser starting.");
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
            LOG.info("Parser finishing.");
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

    /**
     * Add vacancy to database.
     * (подумать как реализовать так, чтобы не было одинаковых вакансий)
     * @param vacancy to be added.
     * @return true if added to database or false if not added.
     */
    private boolean insertInTable(Vacancy vacancy) {
        boolean valid = false;
        String sql = "INSERT INTO vacancies (name, description, link, date) Values (?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, vacancy.getName());
            preparedStatement.setString(2, vacancy.getText());
            preparedStatement.setString(3, vacancy.getLink());
            preparedStatement.setTimestamp(4, Timestamp.valueOf(String.valueOf(vacancy.getDate().getTime())));
            preparedStatement.executeUpdate();
            valid = true;
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return valid;
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
            Connection conn = DriverManager.getConnection(config.get("jdbc.url"), config.get("jdbc.username"), config.get("jdbc.password"));
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
