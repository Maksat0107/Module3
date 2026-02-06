package modul3.delivery;

import modul3.order.Order;

public interface IDelivery {
    DeliveryResult deliverOrder(Order order);
}
