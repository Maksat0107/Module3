package modul3.payment;

import java.util.UUID;

public final class PayPalPayment implements IPayment {
    @Override
    public PaymentResult processPayment(double amount) {
        if (amount <= 0) return PaymentResult.fail("Amount must be > 0");
        return PaymentResult.ok("PP-" + UUID.randomUUID());
    }
}
