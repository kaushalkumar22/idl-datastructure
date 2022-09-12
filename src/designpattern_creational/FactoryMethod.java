package designpattern_creational;

public class FactoryMethod {
	public static void main(String[] args) {
		NotificationFactory notificationFactory = new NotificationFactory();
		Notification notification = notificationFactory.createNotification(NotificationType.WHATSUP_NOTIFICATION);
		notification.sendNotification();
	}
}
class NotificationFactory {

	public Notification createNotification(NotificationType notificationType){  	

		switch (notificationType) {

		case  SMS_NOTIFICATION:
			return new SMSNotification();
		case EMAIL_NOTIFICATION:
			return new EMAILNotification();
		case WHATSUP_NOTIFICATION:
			return new WHATSUPNotification();
		default:
			throw new IllegalArgumentException("Unknown channel");
		}
	}
}
interface Notification{
	public void sendNotification();
}
class SMSNotification implements Notification{

	@Override
	public void sendNotification() {
		System.out.println(NotificationType.SMS_NOTIFICATION);			
	}

}
class WHATSUPNotification implements Notification{

	@Override
	public void sendNotification() {
		System.out.println(NotificationType.WHATSUP_NOTIFICATION);			
	}

}
class EMAILNotification implements Notification{

	@Override
	public void sendNotification() {
		System.out.println(NotificationType.EMAIL_NOTIFICATION);		
	}

}

enum NotificationType {
	SMS_NOTIFICATION, WHATSUP_NOTIFICATION, EMAIL_NOTIFICATION
};