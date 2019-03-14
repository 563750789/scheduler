package com.tw.conference.scheduler.models;

import com.tw.conference.scheduler.common.Constants;

import java.time.LocalTime;
import static com.tw.conference.scheduler.utils.Printer.print;
public class Track {
    private Session morningSession;
    private Session afternoonSession;

    public Track() {
        this.morningSession = new Session(LocalTime.of(9, 00), LocalTime.of(12, 00));
        this.afternoonSession = new Session(LocalTime.of(13, 00), LocalTime.of(17, 00));
    }

    public Session getMorningSession() {
        return morningSession;
    }

    public void setMorningSession(final Session morningSession) {
        this.morningSession = morningSession;
    }

    public Session getAfternoonSession() {
        return afternoonSession;
    }

    public void setAfternoonSession(final Session afternoonSession) {
        this.afternoonSession = afternoonSession;
    }

    public void output() {
        this.morningSession.output();
        print(Constants.LUNCH);
        this.afternoonSession.output();
    }
}
