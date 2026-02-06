package modul3.discount;

import modul3.order.Order;

public final class PercentageDiscountRule implements DiscountRule {
    private final double percent; // 0..100

    public PercentageDiscountRule(double percent) {
        if (percent < 0 || percent > 100) throw new IllegalArgumentException("percent must be 0..100");
        this.percent = percent;
    }

    @Override
    public double calculateDiscount(Order order, double subtotal) {
        return subtotal * (percent / 100.0);
    }
}
