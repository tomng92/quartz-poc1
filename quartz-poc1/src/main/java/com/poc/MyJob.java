package com.poc;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SimpleTrigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyJob implements Job {
    private static final Logger logger = LoggerFactory.getLogger( MyJob.class );
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        SimpleTrigger simple = (SimpleTrigger) context.getTrigger();
        int repeatCount = simple.getRepeatCount();
        logger.debug("-> " + context.getJobDetail().getKey().getName()
                     + " " + (repeatCount - simple.getTimesTriggered() + 1)
                     + " de " + repeatCount);

    }
}
