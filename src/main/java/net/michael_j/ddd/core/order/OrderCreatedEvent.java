package net.michael_j.ddd.core.order;

import net.michael_j.ddd.core.shared.DomainEvent;

import java.util.Date;

public class OrderCreatedEvent implements DomainEvent {
    private String name;
    private String content;

    public OrderCreatedEvent(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    @Override
    public Date occurredTime() {
        return new Date();
    }

    @Override
    public String toString() {
        return "OrderCreatedEvent{" +
                "name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
