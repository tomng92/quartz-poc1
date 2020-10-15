package com.poc;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SimpleTrigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class MyJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        SimpleTrigger simple = (SimpleTrigger) context.getTrigger();
        int repeatCount = simple.getRepeatCount();
        log.info("-> " + context.getJobDetail().getKey().getName()
                     + " " + (repeatCount - simple.getTimesTriggered() + 1)
                     + " de " + repeatCount);

    }
}
