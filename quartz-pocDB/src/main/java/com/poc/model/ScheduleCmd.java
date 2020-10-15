package com.poc.model;

import lombok.Data;
import lombok.ToString;

/**
 * The command will print text according to the inSecs and repeat.
 * {
 *     "startSecs": 0 // start now
 *     "inSecs": 23,
 *     "repeat": 10, // -1 means forever
 *     "jobName": "some name"
 * }
 */
@Data
@ToString(callSuper=true, includeFieldNames=true)
public class ScheduleCmd {
    private int startIn;
    private int interval;
    private int repeat;
    private String jobName;

    public ScheduleCmd() {}

    public String getJobDesc() {
        return getJobName() + "-" + getRepeat() + "X" + getInterval() + "secs";
    }

}
