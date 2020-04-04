package ru.job4j.scheduler;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.Config;
import ru.job4j.Parsers;

import static org.quartz.TriggerBuilder.newTrigger;

public class SchedulerPars {

    private static final Logger LOG = LoggerFactory.getLogger(Parsers.class.getName());

    public void task() throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        JobDetail jobDetail = JobBuilder.newJob(JobPars.class).build();
        Trigger trigger = newTrigger().withIdentity("trigger")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule(Config.getCronTime("app.properties")))
                .startNow()
                .build();
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
   /*     SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        JobDetail jobDetail = newJob(JobPars.class).withIdentity("job1").build();
        JobDataMap dm = jobDetail.getJobDataMap();
        Properties properties = Configurator.getProperties(prop);
        dm.put("prop", properties);
        String cron = properties.getProperty("cron.time");
        Trigger trigger = newTrigger().withIdentity("trigger1").withSchedule(cronSchedule(cron))
                .forJob("job1").build();
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();*/
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
