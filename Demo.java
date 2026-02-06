package modul3;

import modul3.delivery.CourierDelivery;
import modul3.delivery.IDelivery;
import modul3.discount.DiscountCalculator;
import modul3.discount.FixedDiscountOverThresholdRule;
import modul3.discount.PercentageDiscountRule;
import modul3.notification.EmailNotification;
import modul3.notification.NotificationCenter;
import modul3.notification.SmsNotification;
import modul3.order.Order;
import modul3.order.OrderItem;
import modul3.payment.IPayment;
import modul3.payment.PayPalPayment;
import modul3.service.OrderPricing;
import modul3.service.OrderService;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        // Notifications
        NotificationCenter notificationCenter = new NotificationCenter(List.of(
                new EmailNotification("client@mail.com"),
                new SmsNotification("+77001234567")
        ));

        // Discounts (extendable without changing existing code)
        DiscountCalculator discountCalculator = new DiscountCalculator(List.of(
                new PercentageDiscountRule(10),                // -10%
                new FixedDiscountOverThresholdRule(10000, 500) // -500 if subtotal >= 10000
        ));

        OrderService orderService = new OrderService(discountCalculator, notificationCenter);

        // Create order and add items
        Order order = new Order("ORD-1001");
        order.addItem(new OrderItem("SKU-1", "Keyboard", 1, 8000));
        order.addItem(new OrderItem("SKU-2", "Mouse", 2, 1500));

        // Price
        OrderPricing pricing = orderService.price(order);
        System.out.println("Subtotal=" + pricing.getSubtotal()
                + ", Discount=" + pricing.getDiscount()
                + ", Total=" + pricing.getTotal());

        // Pay
        IPayment payment = new PayPalPayment();
        if (!orderService.pay(order, payment, pricing.getTotal()).isSuccess()) return;

        // Deliver
        IDelivery delivery = new CourierDelivery();
        orderService.deliver(order, delivery);
    }
}
