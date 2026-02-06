package modul3.discount;

import modul3.order.Order;

import java.util.List;
import java.util.Objects;

public final class DiscountCalculator {
    private final List<DiscountRule> rules;

    public DiscountCalculator(List<DiscountRule> rules) {
        this.rules = List.copyOf(Objects.requireNonNull(rules));
    }

    public double totalDiscount(Order order, double subtotal) {
        double discount = 0.0;
        for (DiscountRule rule : rules) {
            discount += rule.calculateDiscount(order, subtotal);
        }
        return Math.min(discount, subtotal);
    }
}
