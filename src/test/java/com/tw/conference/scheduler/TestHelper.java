package com.tw.conference.scheduler;

import com.tw.conference.scheduler.models.Session;
import com.tw.conference.scheduler.models.Talk;
import com.tw.conference.scheduler.models.Track;

import java.time.LocalTime;
import java.util.ArrayList;

public class TestHelper {

    private static ArrayList<Talk> talkList = new ArrayList<>();
    private static Session session;
    private static ArrayList<Track> trackList = new ArrayList<>();

    static {
        talkList.add(new Talk("a ", 5));
        talkList.add(new Talk("b ", 30));
        talkList.add(new Talk("c ", 45));
        talkList.add(new Talk("d ", 200));

        Session session1 = new Session(LocalTime.of(9, 0), LocalTime.of(12, 0));
        session1.setLength(180L);
        session1.setTalks(talkList);
        session = session1;

        Track track = new Track();
        track.setMorningSession(session);
        trackList.add(track);
    }

    public static ArrayList<Talk> getTalkList() {
        return talkList;
    }

    public static Session getSession() {
        return session;
    }

    public static ArrayList<Track> getTrackList() {
        return trackList;
    }
}
