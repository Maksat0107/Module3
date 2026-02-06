package modul3.delivery;

public final class DeliveryResult {
    private final boolean accepted;
    private final String trackingNumber;
    private final String message;

    private DeliveryResult(boolean accepted, String trackingNumber, String message) {
        this.accepted = accepted;
        this.trackingNumber = trackingNumber;
        this.message = message;
    }

    public static DeliveryResult accepted(String trackingNumber) {
        return new DeliveryResult(true, trackingNumber, "ACCEPTED");
    }

    public static DeliveryResult rejected(String message) {
        return new DeliveryResult(false, null, message);
    }

    public boolean isAccepted() { return accepted; }
    public String getTrackingNumber() { return trackingNumber; }
    public String getMessage() { return message; }
}
