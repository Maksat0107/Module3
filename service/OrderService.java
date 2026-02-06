package modul3.service;

import modul3.discount.DiscountCalculator;
import modul3.delivery.DeliveryResult;
import modul3.delivery.IDelivery;
import modul3.notification.NotificationCenter;
import modul3.order.Order;
import modul3.order.OrderStatus;
import modul3.payment.IPayment;
import modul3.payment.PaymentResult;

import java.util.Objects;

public final class OrderService {
    private final DiscountCalculator discountCalculator;
    private final NotificationCenter notificationCenter;

    public OrderService(DiscountCalculator discountCalculator, NotificationCenter notificationCenter) {
        this.discountCalculator = Objects.requireNonNull(discountCalculator);
        this.notificationCenter = Objects.requireNonNull(notificationCenter);
    }

    public OrderPricing price(Order order) {
        double subtotal = order.subtotal();
        double discount = discountCalculator.totalDiscount(order, subtotal);
        double total = subtotal - discount;

        order.setStatus(OrderStatus.PRICED);
        notificationCenter.notifyAllChannels("Order " + order.getOrderId() + " priced. Total=" + total);

        return new OrderPricing(subtotal, discount, total);
    }

    public PaymentResult pay(Order order, IPayment payment, double amountToPay) {
        PaymentResult result = payment.processPayment(amountToPay);

        if (result.isSuccess()) {
            order.setStatus(OrderStatus.PAID);
            notificationCenter.notifyAllChannels("Order " + order.getOrderId() + " paid. Tx=" + result.getTransactionId());
        } else {
            notificationCenter.notifyAllChannels("Payment failed for order " + order.getOrderId() + ": " + result.getMessage());
        }
        return result;
    }

    public DeliveryResult deliver(Order order, IDelivery delivery) {
        DeliveryResult result = delivery.deliverOrder(order);

        if (result.isAccepted()) {
            order.setStatus(OrderStatus.SHIPPED);
            notificationCenter.notifyAllChannels("Order " + order.getOrderId() + " shipped. Track=" + result.getTrackingNumber());
        } else {
            notificationCenter.notifyAllChannels("Delivery rejected for order " + order.getOrderId() + ": " + result.getMessage());
        }
        return result;
    }
}
