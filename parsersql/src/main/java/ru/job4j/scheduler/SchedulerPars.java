package ru.job4j.scheduler;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.Config;
import ru.job4j.Parsers;

public class SchedulerPars {

    private static final Logger LOG = LoggerFactory.getLogger(Parsers.class.getName());

    private void task() {
        try {
            JobDetail jobDetail = JobBuilder.newJob(JobPars.class).build();
            JobDataMap jobDataMap = jobDetail.getJobDataMap();
            jobDataMap.put("nameProperties", "app.properties");
            Trigger trigger = TriggerBuilder
                    .newTrigger()
                    .withIdentity("trigger")
                    .withSchedule(CronScheduleBuilder.cronSchedule(Config.getCronTime("app.properties")))
                    .build();
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
  }

    public static void main(String[] args) {
       SchedulerPars sp = new SchedulerPars();
       try {
           sp.task();
       } catch (SchedulerException e) {
           LOG.error("ERROR", e);
       }
    }

}
