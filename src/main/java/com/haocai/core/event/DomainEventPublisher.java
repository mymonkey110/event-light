package com.haocai.core.event;


/**
 * Created by Michael Jiang on 16/1/12.
 */
public interface DomainEventPublisher<T> {
    String identify();

    void register(Object listener);

    void publish(T event);

    void asyncPublish(T event);
}
