package com.thanh;

import java.util.concurrent.*;

/**
 * Interesting article:
 * https://medium.com/@leventov/cronscheduler-a-reliable-java-scheduler-for-external-interactions-cb7ce4a4f2cd
 */
public class PlaySched1 {
    public static void main(String[] args) {

        ItfWithDefaultMethod itf = new ItfWithDefaultMethod() {
            @Override
            public void doSomething() {
                System.out.println("doing soemthing");
            }
        };
        System.out.println("===> " + itf.getX());


        System.out.println("[[scheduling a task.");
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        ScheduledFuture<String> scheduledFuture =
                scheduledExecutorService.schedule(new Callable() {
                                                      public String call() throws Exception {
                                                          System.out.println("Task executed!");
                                                          return "Called!";
                                                      }
                                                  },
                        5,
                        TimeUnit.SECONDS);

        System.out.println("]]");
    }

    private interface ItfWithDefaultMethod {
        public void doSomething();
        default public String getX() {
            return "default method here!";
        }
    }
 }
