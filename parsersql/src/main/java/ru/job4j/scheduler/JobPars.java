package ru.job4j.scheduler;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.Config;
import ru.job4j.Parsers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JobPars implements Job {

    private static final Logger LOG = LoggerFactory.getLogger(JobPars.class);
    private Connection connection;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        LOG.info("Parser starting");
        String properties = jobExecutionContext.getJobDetail().getJobDataMap().get("nameProperties").toString();
        connection = Config.getConnection(properties);
        this.createTable();
        Date date = getLastJobDB();
        if (date != null) {
            this.runParser(connection, date);
        } else {
            this.runParser(connection, this.getBeginningYear());
        }
        LOG.info("Stop parsing");
    }

    private Date getLastJobDB() {
        String sql = "SELECT * FROM jobs order by ID desc LIMIT 1";
        Date rst = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                rst = resultSet.getTimestamp("date");
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return rst;
    }

    private Date getBeginningYear() {
        Date rst = new Date();
        try {
            rst = new SimpleDateFormat("dd-MM-yyyy").parse("01-01-" + Calendar.getInstance().get(Calendar.YEAR));
        } catch (ParseException e) {
            LOG.error(e.getMessage(), e);
        }
        return rst;
    }

    private void createTable() {
        String sql = "CREATE TABLE if not exists jobs ("
                + "id serial primary key,"
                + "name varchar(255),"
                + "date timestamp)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
//           LOG.error(e.getMessage(), e);
        }
    }

    private void addJobDB() {
        String sql = "INSERT INTO jobs (name, date) Values (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, this.getClass().getSimpleName());
            preparedStatement.setTimestamp(2, new java.sql.Timestamp(System.currentTimeMillis()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    private void runParser(Connection connection, Date date) {
        try (Parsers parser = new Parsers(connection)) {
            parser.run();
            addJobDB();
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }
}
