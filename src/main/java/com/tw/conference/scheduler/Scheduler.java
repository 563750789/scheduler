package com.tw.conference.scheduler;

import com.tw.conference.scheduler.exceptions.InvalidFormatException;
import com.tw.conference.scheduler.models.Conference;
import com.tw.conference.scheduler.models.Talk;
import com.tw.conference.scheduler.utils.TalksParser;

import java.util.List;

import static com.tw.conference.scheduler.utils.Printer.print;

public class Scheduler {

    public static void main(String[] args) {
        new Scheduler().schedule("talks.txt");
    }

    public void schedule(final String filePath) {
        try {
            List<Talk> talks = new TalksParser().parse(filePath);
            Conference conference = new Conference();
            conference.schedule(talks);
            conference.output();
        } catch (InvalidFormatException e) {
            print(e.getMessage());
        } catch (Exception e) {
            print("System error when schedule conference.");
        }
    }



}
