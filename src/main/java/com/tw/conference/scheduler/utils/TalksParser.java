package com.tw.conference.scheduler.utils;

import com.tw.conference.scheduler.common.Constants;
import com.tw.conference.scheduler.exceptions.InvalidFormatException;
import com.tw.conference.scheduler.models.Talk;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TalksParser {

    private static final Pattern PATTERN = Pattern.compile("^(\\D+)\\s*([0-9]+min|lightning)$");

    public static List<Talk> parse(final String path) throws IOException, InvalidFormatException {
        List<Talk> talks = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            String st;
            while ((st = br.readLine()) != null) {
                Matcher m = TalksParser.PATTERN.matcher(st);
                if (m.find()) {
                    String topic = m.group(1).trim();
                    Integer length =
                            Integer.parseInt(m.group(2).equals(Constants.LIGHTING) ? "5" : m.group(2).replace(Constants.MIN, ""));
                    talks.add(new Talk(topic, length));
                } else {
                    throw new InvalidFormatException("Talks file contain invalid content :" + st);
                }
            }
        } finally {
            br.close();
        }
        return talks;
    }
}
