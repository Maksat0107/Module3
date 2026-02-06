package modul3.notification;

import java.util.Objects;

public final class EmailNotification implements INotification {
    private final String email;

    public EmailNotification(String email) {
        this.email = Objects.requireNonNull(email);
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("[EMAIL to " + email + "] " + message);
    }
}
