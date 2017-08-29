package net.michael_j.ddd.application.service;

import net.michael_j.ddd.core.order.OrderCreatedEvent;
import net.michael_j.ddd.core.shared.DomainEventPublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private static Logger LOG = LoggerFactory.getLogger(OrderService.class);

    public void createOrder(long uid, String name, String content) {
        LOG.info("user:{} create order:{}-{}.", uid, name, content);
        DomainEventPublisher.publish(new OrderCreatedEvent(name, content));
    }
}
