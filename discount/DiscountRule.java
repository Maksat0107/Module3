package modul3.discount;

import modul3.order.Order;

public interface DiscountRule {
    /**
     * @return discount amount (money) to subtract from subtotal
     */
    double calculateDiscount(Order order, double subtotal);
}
