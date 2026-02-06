package modul3.notification;

import java.util.List;
import java.util.Objects;

public final class NotificationCenter {
    private final List<INotification> channels;

    public NotificationCenter(List<INotification> channels) {
        this.channels = List.copyOf(Objects.requireNonNull(channels));
    }

    public void notifyAllChannels(String message) {
        for (INotification c : channels) {
            c.sendNotification(message);
        }
    }
}
