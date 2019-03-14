package com.tw.conference.scheduler.models;

import com.tw.conference.scheduler.TestHelper;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SessionTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    public void constructorTest() {

        Session session = new Session(LocalTime.of(9, 00), LocalTime.of(12, 00));
        assertEquals(180, session.getLength());
        assertEquals(true, session.getTalks().isEmpty());
    }

    @Test
    public void output() {
        System.setOut(new PrintStream(outContent));
        Session session = TestHelper.getSession();
        session.output();
        assertEquals("09:00 AM a  lightning" + System.lineSeparator() +
                "09:05 AM b  30min" + System.lineSeparator() +
                "09:35 AM c  45min" + System.lineSeparator() +
                "10:20 AM d  200min"+System.lineSeparator(), outContent.toString());

    }
}