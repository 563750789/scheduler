package com.tw.conference.scheduler.models;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.tw.conference.scheduler.utils.Printer.print;

public class Session {

    private List<Talk> talks;
    private LocalTime beginTime;
    private LocalTime endTime;
    private Long length;

    public Session(final LocalTime beginTime, final LocalTime endTime) {
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.length = Duration.between(beginTime, endTime).toMinutes();
        this.talks = new ArrayList<>();
    }

    public void output() {
        LocalTime time = this.beginTime;
        for (Talk talk : this.talks) {
            print(time.format(DateTimeFormatter.ofPattern("hh:mm a").withLocale(Locale.US)) + " " + talk.toString());
            time = time.plusMinutes(talk.getLength());
        }
    }

    public void setTalks(List<Talk> talks) {
        this.talks = talks;
    }

    public List<Talk> getTalks() {
        return talks;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }
}
