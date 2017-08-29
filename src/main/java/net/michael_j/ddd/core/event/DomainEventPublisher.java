package net.michael_j.ddd.core.event;

/**
 * 领域事件发射器
 * Created by Michael Jiang on 16/1/12.
 */
public interface DomainEventPublisher<T extends DomainEvent> {
    String identify();

    void register(Object listener);

    void publish(T event);

    void asyncPublish(T event);
}
