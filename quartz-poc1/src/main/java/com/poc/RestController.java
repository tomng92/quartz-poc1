package com.poc;

import com.poc.model.ScheduleCmd;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    
    private static final Logger logger = LoggerFactory.getLogger( RestController.class );

    @Autowired
    private Scheduler scheduler;

    @GetMapping("/")
    public String home() {
        return "Hello quartz poc!";
    }

    /**
     * Scheduling a job
     * @param cmd
     */
    @PostMapping("/sched")
    public void schedule(@RequestBody ScheduleCmd cmd) throws SchedulerException {

        if (!scheduler.isStarted()) {
            scheduler.start();
        }

        System.out.println("==============> Received: " + cmd + " - " + cmd.getJobName());

        startJob(cmd);
    }

    /**
     *
     * @param cmd
     */
    private void startJob(ScheduleCmd cmd) throws SchedulerException {

        JobDetail job = newJob(MyJob.class).withIdentity(cmd.getJobDesc()).build();

        Trigger trigger = newTrigger().withDescription(cmd.getJobDesc()).startNow()
                            .withSchedule(simpleSchedule().withIntervalInSeconds(cmd.getInterval()).withRepeatCount(cmd.getRepeat()))
                            .build();

        scheduler.scheduleJob(job, trigger);

        logger.debug("Job " + cmd.getJobDesc() + " scheduled");
    }
}
