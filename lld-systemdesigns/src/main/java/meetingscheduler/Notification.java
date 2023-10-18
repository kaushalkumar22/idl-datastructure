package meetingscheduler;

import java.text.SimpleDateFormat;
import java.util.List;

public class Notification {

    public static void sendNotification(String emailId, String message) {
        System.out.println("Dear user: "+ emailId +", "+message);
    }
}
