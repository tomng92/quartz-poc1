package com.poc;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class QuartzPoc1Application {
	private static final Logger logger = LoggerFactory.getLogger( QuartzPoc1Application.class );

	public static void main(String[] args) {
		SpringApplication.run(QuartzPoc1Application.class, args);
	}

//	@Bean
//	public Scheduler getScheduler() throws SchedulerException {
//		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
//
//		scheduler.start();
//
//		logger.debug("=========== Scheduler started!!!");
//		return scheduler;
//	}

}
