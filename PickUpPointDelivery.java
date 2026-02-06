package modul3.delivery;

import modul3.order.Order;

import java.util.UUID;

public final class PickUpPointDelivery implements IDelivery {
    @Override
    public DeliveryResult deliverOrder(Order order) {
        return DeliveryResult.accepted("PU-" + UUID.randomUUID());
    }
}
