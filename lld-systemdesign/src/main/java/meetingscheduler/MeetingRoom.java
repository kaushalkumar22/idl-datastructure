package meetingscheduler;

import java.util.ArrayList;
import java.util.List;

public class MeetingRoom {
    private String roomId;
    private int capacity;
    private String roomName;

    public MeetingRoom(String roomId, int capacity, String roomName) {
        this.roomId = roomId;
        this.capacity = capacity;
        this.roomName = roomName;
    }

    public String getRoomId() {
        return roomId;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getRoomName() {
        return roomName;
    }
}
