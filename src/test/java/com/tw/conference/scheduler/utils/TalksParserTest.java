package com.tw.conference.scheduler.utils;

import com.tw.conference.scheduler.exceptions.InvalidFormatException;
import com.tw.conference.scheduler.models.Talk;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TalksParserTest {

    @Test
    public void testSuccess() {
        try {
            List<Talk> talks = TalksParser.parse("src/test/resources/mockdata/talks.txt");
            assertEquals(19, talks.size());
            assertEquals("Writing Fast Tests Against Enterprise Rails", talks.get(0).getTopic());
        } catch (IOException | InvalidFormatException e) {
            fail("Error when test parse talks");
        }
    }

    @Test
    void testThrowInvalidFormatExeption() {
        assertThrows(InvalidFormatException.class, () -> {
            TalksParser.parse("src/test/resources/mockdata/error_talks.txt");
        });
    }
}