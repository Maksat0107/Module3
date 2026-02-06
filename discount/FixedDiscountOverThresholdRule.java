package modul3.discount;

import modul3.order.Order;

public final class FixedDiscountOverThresholdRule implements DiscountRule {
    private final double threshold;
    private final double fixedDiscount;

    public FixedDiscountOverThresholdRule(double threshold, double fixedDiscount) {
        if (threshold < 0) throw new IllegalArgumentException("threshold must be >= 0");
        if (fixedDiscount < 0) throw new IllegalArgumentException("fixedDiscount must be >= 0");
        this.threshold = threshold;
        this.fixedDiscount = fixedDiscount;
    }

    @Override
    public double calculateDiscount(Order order, double subtotal) {
        return subtotal >= threshold ? fixedDiscount : 0.0;
    }
}
