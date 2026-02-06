package modul3.order;

import java.util.Objects;

public final class OrderItem {
    private final String sku;
    private final String name;
    private final int quantity;
    private final double unitPrice;

    public OrderItem(String sku, String name, int quantity, double unitPrice) {
        if (quantity <= 0) throw new IllegalArgumentException("quantity must be > 0");
        if (unitPrice < 0) throw new IllegalArgumentException("unitPrice must be >= 0");
        this.sku = Objects.requireNonNull(sku);
        this.name = Objects.requireNonNull(name);
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getSku() { return sku; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public double getUnitPrice() { return unitPrice; }

    public double lineTotal() {
        return unitPrice * quantity;
    }
}
