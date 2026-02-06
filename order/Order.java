package modul3.order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Order {
    private final String orderId;
    private final List<OrderItem> items = new ArrayList<>();
    private OrderStatus status = OrderStatus.NEW;

    public Order(String orderId) {
        this.orderId = Objects.requireNonNull(orderId);
    }

    public String getOrderId() { return orderId; }

    public List<OrderItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public OrderStatus getStatus() { return status; }

    public void addItem(OrderItem item) {
        items.add(Objects.requireNonNull(item));
    }

    public double subtotal() {
        return items.stream().mapToDouble(OrderItem::lineTotal).sum();
    }

    public void setStatus(OrderStatus status) {
        this.status = Objects.requireNonNull(status);
    }
}
