package modul3.payment;

import java.util.UUID;

public final class BankTransferPayment implements IPayment {
    @Override
    public PaymentResult processPayment(double amount) {
        if (amount <= 0) return PaymentResult.fail("Amount must be > 0");
        return PaymentResult.ok("BT-" + UUID.randomUUID());
    }
}
