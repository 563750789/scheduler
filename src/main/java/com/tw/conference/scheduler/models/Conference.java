package com.tw.conference.scheduler.models;

import com.tw.conference.scheduler.common.Constants;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.tw.conference.scheduler.utils.Printer.print;

public class Conference {

    List<Track> tracks;

    public Conference() {
        this.tracks = new ArrayList<Track>();
    }

    public void schedule(final List<Talk> talks) {
        talks.sort((o1,o2)->o2.getLength()-o1.getLength());
        while (talks.size() > 0) {
            Track track = new Track();
            Iterator<Talk> iterator = talks.iterator();
            while (iterator.hasNext()) {
                Talk talk = iterator.next();
                if (track.getMorningSession().getLength() >= talk.getLength()) {
                    track.getMorningSession().getTalks().add(talk);
                    track.getMorningSession().setLength(track.getMorningSession().getLength() - talk.getLength());
                    iterator.remove();
                } else if (track.getAfternoonSession().getLength() >= talk.getLength()) {
                    track.getAfternoonSession().getTalks().add(talk);
                    track.getAfternoonSession().setLength(
                            track.getAfternoonSession().getLength() - talk.getLength());
                    iterator.remove();
                }
            }
            track.getAfternoonSession().getTalks().add(new Talk(Constants.NETWORKING, -1));
            this.tracks.add(track);
        }
    }

    public void output() {
        for (int i = 0; i < tracks.size(); i++) {
            print("Track " + (i + 1));
            this.tracks.get(i).output();
        }
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public List<Track> getTracks() {
        return tracks;
    }
}
