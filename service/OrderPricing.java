package modul3.service;

public final class OrderPricing {
    private final double subtotal;
    private final double discount;
    private final double total;

    public OrderPricing(double subtotal, double discount, double total) {
        this.subtotal = subtotal;
        this.discount = discount;
        this.total = total;
    }

    public double getSubtotal() { return subtotal; }
    public double getDiscount() { return discount; }
    public double getTotal() { return total; }
}
