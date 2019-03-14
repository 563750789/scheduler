package com.tw.conference.scheduler;

import com.tw.conference.scheduler.exceptions.InvalidFormatException;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class SchedulerTest {
    private Scheduler scheduler = new Scheduler();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    void testSuccess() {
        System.setOut(new PrintStream(outContent));
        this.scheduler.schedule("src/test/resources/mockdata/talks.txt");
        assertEquals("Track 1" + System.lineSeparator() +
                "09:00 AM Writing Fast Tests Against Enterprise Rails 60min" + System.lineSeparator() +
                "10:00 AM Communicating Over Distance 60min" + System.lineSeparator() +
                "11:00 AM Rails Magic 60min" + System.lineSeparator() +
                "12:00 PM lunch" + System.lineSeparator() +
                "01:00 PM Ruby on Rails: Why We Should Move On 60min" + System.lineSeparator() +
                "02:00 PM Ruby on Rails Legacy App Maintenance 60min" + System.lineSeparator() +
                "03:00 PM Overdoing it in Python 45min" + System.lineSeparator() +
                "03:45 PM Ruby Errors from Mismatched Gem Versions 45min" + System.lineSeparator() +
                "04:30 PM Lua for the Masses 30min" + System.lineSeparator() +
                "05:00 PM Networking Event " + System.lineSeparator() +
                "Track 2" + System.lineSeparator() +
                "09:00 AM Common Ruby Errors 45min" + System.lineSeparator() +
                "09:45 AM Accounting-Driven Development 45min" + System.lineSeparator() +
                "10:30 AM Pair Programming vs Noise 45min" + System.lineSeparator() +
                "11:15 AM Clojure Ate Scala (on my project) 45min" + System.lineSeparator() +
                "12:00 PM lunch" + System.lineSeparator() +
                "01:00 PM Woah 30min" + System.lineSeparator() +
                "01:30 PM Sit Down and Write 30min" + System.lineSeparator() +
                "02:00 PM Programming in the Boondocks of Seattle 30min" + System.lineSeparator() +
                "02:30 PM Ruby vs. Clojure for Back-End Development 30min" + System.lineSeparator() +
                "03:00 PM A World Without HackerNews 30min" + System.lineSeparator() +
                "03:30 PM User Interface CSS in Rails Apps 30min" + System.lineSeparator() +
                "04:00 PM Rails for Python Developers lightning" + System.lineSeparator() +
                "04:05 PM Networking Event " + System.lineSeparator(), outContent.toString());
    }

    @Test
    void testThrowInvalidFormatException() {
        System.setOut(new PrintStream(outContent));
        new Scheduler().schedule("src/test/resources/mockdata/error_talks.txt");
       assertEquals("Talks file contain invalid content :Overdoing it in Python min"+System.lineSeparator(),outContent.toString());
    }

    @Test
    void testThrowOtherException() {
        System.setOut(new PrintStream(outContent));
        this.scheduler.schedule(null);
        assertEquals("System error when schedule conference." + System.lineSeparator(), outContent.toString());
    }
}