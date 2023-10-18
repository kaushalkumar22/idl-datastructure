package meetingscheduler;

import java.text.SimpleDateFormat;
import java.util.*;

public class MeetingScheduler {
    private List<Meeting> meetings;
    private List<MeetingRoom> meetingRooms;
    private Map<String, TreeMap<Date,Date>> roomIdIdVsSchedule;

    public MeetingScheduler() {
        this.meetings = new ArrayList<>();
        this.meetingRooms = new ArrayList<>();
        this.roomIdIdVsSchedule = new HashMap<>();
    }
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm aa");
    public void scheduleMeeting(String title, Date startTime, Date endTime,
                                User organizer, List<User> participants, MeetingRoom room) {
        if (isMeetingRoomAvailable(room.getRoomId(),startTime,endTime)) {
            Meeting meeting = new Meeting(title, startTime, endTime,organizer, participants, room);
            meetings.add(meeting);
            roomIdIdVsSchedule.putIfAbsent(room.getRoomId(), new TreeMap<>());
            roomIdIdVsSchedule.get(room.getRoomId()).put(startTime, endTime);
            List<User> attendees = meeting.getParticipants();
            for (User attendee : attendees) {
                String message ="Meeting :" +title + "  From "
                        + simpleDateFormat.format(endTime)
                        + " to "+ simpleDateFormat.format(endTime)
                        + " in meeting room :"+ meeting.getRoom().getRoomName();
                Notification.sendNotification(attendee.getEmailId(),message);
            }
        }else{
            Notification.sendNotification(organizer.getEmailId(), "Meeting room " +room.getRoomName()
                    + " not available between " +
                    " "+ simpleDateFormat.format(startTime)
                    + " to "+ simpleDateFormat.format(endTime));
        }
    }

    private boolean isMeetingRoomAvailable(String roomId,Date newStart, Date newEnd) {
        TreeMap<Date,Date> interval = roomIdIdVsSchedule.get(roomId);
        if(interval==null || interval.isEmpty()) return true;
        Date start = interval.floorKey(newStart);
        Date end = interval.get(start);

        if(newStart.getTime()<start.getTime() && start.getTime()<newEnd.getTime() ||
                newStart.getTime()<end.getTime() && newEnd.getTime()>end.getTime()
                ||newStart.getTime()>=start.getTime() && newStart.getTime()<=end.getTime()) {
            return false;
        }
        return true;
    }

    public void cancelMeeting(Meeting meeting) {
        meetings.remove(meeting);
    }

    public void rescheduleMeeting(Meeting meeting, Date newStartDate, Date newEndDate) {
        meeting.setStartTime(newStartDate);
        meeting.setEndTime(newEndDate);
    }

    public boolean addRoom(MeetingRoom room) {
        return meetingRooms.add(room);
    }

    public boolean removeRoom(MeetingRoom room) {
        return  meetingRooms.remove(room);
    }

    public List<Meeting> listMeetings() {
        return meetings;
    }

}
