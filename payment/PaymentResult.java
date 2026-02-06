package modul3.payment;

public final class PaymentResult {
    private final boolean success;
    private final String transactionId;
    private final String message;

    private PaymentResult(boolean success, String transactionId, String message) {
        this.success = success;
        this.transactionId = transactionId;
        this.message = message;
    }

    public static PaymentResult ok(String transactionId) {
        return new PaymentResult(true, transactionId, "OK");
    }

    public static PaymentResult fail(String message) {
        return new PaymentResult(false, null, message);
    }

    public boolean isSuccess() { return success; }
    public String getTransactionId() { return transactionId; }
    public String getMessage() { return message; }
}
