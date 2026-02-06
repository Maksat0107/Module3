package modul3.notification;

import java.util.Objects;

public final class SmsNotification implements INotification {
    private final String phone;

    public SmsNotification(String phone) {
        this.phone = Objects.requireNonNull(phone);
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("[SMS to " + phone + "] " + message);
    }
}
