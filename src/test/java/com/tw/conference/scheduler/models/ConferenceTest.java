package com.tw.conference.scheduler.models;

import com.tw.conference.scheduler.Scheduler;
import com.tw.conference.scheduler.TestHelper;
import com.tw.conference.scheduler.exceptions.InvalidFormatException;
import com.tw.conference.scheduler.utils.TalksParser;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConferenceTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    void constructorTest() {
        Conference conference = new Conference();
        assertEquals(true, conference.getTracks().isEmpty());
    }

    @Test
    void schedule(){
        System.setOut(new PrintStream(outContent));
        Conference conference = new Conference();
        conference.setTracks(TestHelper.getTrackList());
        conference.output();
        assertEquals("Track 1" +System.lineSeparator()+
                "09:00 AM a  lightning" +System.lineSeparator()+
                "09:05 AM b  30min" +System.lineSeparator()+
                "09:35 AM c  45min" +System.lineSeparator()+
                "10:20 AM d  200min" +System.lineSeparator()+
                "12:00 PM lunch"+System.lineSeparator(),outContent.toString());
    }

}