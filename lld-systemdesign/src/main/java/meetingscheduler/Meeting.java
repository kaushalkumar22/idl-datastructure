package meetingscheduler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Meeting {
    private String title;
    private Date startTime;
    private Date endTime;
    private List<User> participants;
    private User organizer;
    private MeetingRoom room;

    public Meeting(String title, Date startTime, Date endTime, User organizer,List<User> participants, MeetingRoom room) {
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.participants = participants;
        this.organizer = organizer;
        this.room = room;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }

    public User getOrganizer() {
        return organizer;
    }

    public void setOrganizer(User organizer) {
        this.organizer = organizer;
    }

    public MeetingRoom getRoom() {
        return room;
    }

    public void setRoom(MeetingRoom room) {
        this.room = room;
    }

}
