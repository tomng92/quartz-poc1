package com.poc.quartz;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.io.IOException;
import java.util.Properties;

@Configuration
public class QuartzConfig {

    private ApplicationContext applicationContext;

//    @Bean
//    public SchedulerFactoryBean schedulerFactoryBean() throws IOException {
//
//        SchedulerFactoryBean schedulerFactory = new SchedulerFactoryBean();
//        schedulerFactory.setApplicationContext(applicationContext);
//        schedulerFactory.setQuartzProperties(quartzProperties());
//        schedulerFactory.setWaitForJobsToCompleteOnShutdown(true);
//        return schedulerFactory;
//
//    }


    /*
     * Initializing quartz properties from quartz.properties file
     */
    @Bean
    public Properties quartzProperties() throws IOException {

        PropertiesFactoryBean propertiesFactoryBean = new
                PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new
                ClassPathResource("/quartz.properties"));
        propertiesFactoryBean.afterPropertiesSet();
        return propertiesFactoryBean.getObject();

    }
}
