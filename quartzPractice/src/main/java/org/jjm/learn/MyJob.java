package org.jjm.learn;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyJob implements org.quartz.Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Date data = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("current time is " + simpleDateFormat.format(data));
        System.out.println("hello world!");
    }
}
