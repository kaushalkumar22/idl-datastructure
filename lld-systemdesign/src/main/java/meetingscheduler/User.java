package meetingscheduler;

public class User {
    private int id;
    private String name;
    private String emailId;

    public User(int id, String name, String emailId) {
        this.id = id;
        this.name = name;
        this.emailId = emailId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmailId() {
        return emailId;
    }
}
