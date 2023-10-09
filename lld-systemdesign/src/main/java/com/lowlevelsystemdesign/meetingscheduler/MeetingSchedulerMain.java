package com.lowlevelsystemdesign.meetingscheduler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MeetingSchedulerMain {

    public static void main(String[] args) throws ParseException {

            //Meeting room creation
            MeetingRoom meetingRoom1 = new MeetingRoom("Room1", 10,"Ganga");
            MeetingRoom meetingRoom2 = new MeetingRoom("room2", 10,"Yamuna");

            //Users creation
            User user1 = new User(1,"user1", "user1@user.com");
            User user2 = new User(2, "user2", "user2@user.com");
            User user3 = new User(3, "user3", "user3@user.com");
            User user4 = new User(4, "user4", "user4@user.com");
            User user5 = new User(5, "user5", "user5@user.com");

            //attendees
            List<User> attendees = new ArrayList<User>();
            attendees.add(user4);
            attendees.add(user5);
            attendees.add(user1);
            attendees.add(user3);

            //creation of meeting1
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm aa");
            MeetingScheduler ms = new MeetingScheduler();
            ms.scheduleMeeting("Meeting 1", simpleDateFormat.parse("10:00 am"),
                    simpleDateFormat.parse("11:30 am"),user2,attendees,meetingRoom1);

            ms.scheduleMeeting("Meeting 1", simpleDateFormat.parse("11:31 am"),
                    simpleDateFormat.parse("12:3 am"),user2,attendees,meetingRoom1);

        }

    }
