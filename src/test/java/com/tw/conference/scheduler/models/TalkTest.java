package com.tw.conference.scheduler.models;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class TalkTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    public void constructorTest() {
        Talk talk = new Talk("a", 20);
        assertEquals("a", talk.getTopic());
        assertEquals(20, talk.getLength());
    }

    @Test
    public void toStringTest() {
        Talk talk = new Talk("a", 20);
        assertEquals("a 20min",talk.toString());
    }
}