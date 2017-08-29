package net.michael_j.ddd.core.shared;

/**
 * 领域事件订阅器
 * Created by Michael Jiang on 16-11-17.
 */
public interface DomainEventSubscriber<T extends DomainEvent> {

    /**
     * 订阅者处理事件
     *
     * @param event 领域事件
     */
    void handle(T event);
}
