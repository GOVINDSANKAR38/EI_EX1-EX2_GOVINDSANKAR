import java.util.Scanner;


interface Notification {
    void send(String message);
}

class EmailNotification implements Notification {
    public void send(String msg) { System.out.println("📧 Email: " + msg); }
}

class SMSNotification implements Notification {
    public void send(String msg) { System.out.println("📱 SMS: " + msg); }
}

class PushNotification implements Notification {
    public void send(String msg) { System.out.println("🔔 Push: " + msg); }
}


class NotificationFactory {
    public static Notification createNotification(String type) {
        return switch (type.toLowerCase()) {
            case "email" -> new EmailNotification();
            case "sms" -> new SMSNotification();
            case "push" -> new PushNotification();
            default -> throw new IllegalArgumentException("Unknown type: " + type);
        };
    }
}


public class NotificationAppFactoryPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter notification type (email/sms/push): ");
        String type = sc.nextLine();

        System.out.print("Enter the message to send: ");
        String message = sc.nextLine();

        try {
            Notification notification = NotificationFactory.createNotification(type);
            notification.send(message);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
