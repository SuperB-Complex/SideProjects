package org.jjm.learn;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyScheduler {

    public static void main(String[] str) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class).withIdentity("myJob", "myGroup").build();

        System.out.println("the name is " + jobDetail.getKey().getName());
        System.out.println("the group is " + jobDetail.getKey().getGroup());
        System.out.println("the job class id " + jobDetail.getJobClass());

        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("myTrigger", "myGroup").startNow().withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(10).repeatForever()).build();

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();

            Scheduler scheduler = schedulerFactory.getScheduler();
            scheduler.start();
            Date data = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println("current time is " + simpleDateFormat.format(data));
            scheduler.scheduleJob(jobDetail, trigger);

    }
}
