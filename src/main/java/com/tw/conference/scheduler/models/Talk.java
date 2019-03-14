package com.tw.conference.scheduler.models;

import com.tw.conference.scheduler.common.Constants;

public class Talk {

    private String topic;
    private Integer length;

    public Talk(String topic, Integer length) {
        this.topic = topic;
        this.length = length;
    }

    public String getTopic() {
        return topic;
    }

    public Integer getLength() {
        return length;
    }

    public String toString() {
        String duration = "";
        if (this.length == 5) {
            duration = Constants.LIGHTING;
        } else if (this.length > 5) {
            duration = this.length + Constants.MIN;
        }
        return this.topic + " " + duration;
    }
}
