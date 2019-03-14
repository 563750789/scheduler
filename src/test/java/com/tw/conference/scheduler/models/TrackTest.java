package com.tw.conference.scheduler.models;

import com.tw.conference.scheduler.TestHelper;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class TrackTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    public void constructorTest() {
        Track track = new Track();
        assertEquals(180,track.getMorningSession().getLength());
        assertEquals(240,track.getAfternoonSession().getLength());

    }

    @Test
    void output() {
        System.setOut(new PrintStream(outContent));
        Track track = new Track();
        track.setAfternoonSession(TestHelper.getSession());
        track.output();
        assertEquals("12:00 PM lunch" +System.lineSeparator()+
                "09:00 AM a  lightning" +System.lineSeparator()+
                "09:05 AM b  30min" +System.lineSeparator()+
                "09:35 AM c  45min" +System.lineSeparator()+
                "10:20 AM d  200min"+System.lineSeparator(),outContent.toString());

    }
}