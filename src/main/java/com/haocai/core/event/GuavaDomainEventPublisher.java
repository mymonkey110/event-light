package com.haocai.core.event;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import java.util.concurrent.Executors;


/**
 * Created by Michael Jiang on 16/1/12.
 */
public abstract class GuavaDomainEventPublisher<T> implements DomainEventPublisher<T> {
    private EventBus syncBus = new EventBus(identify());
    private EventBus asyncBus = new AsyncEventBus(identify(), Executors.newFixedThreadPool(1));

    @Override
    public void register(Object listener) {
        syncBus.register(listener);
        asyncBus.register(listener);
    }

    @Override
    public void publish(T event) {
        syncBus.post(event);
    }

    @Override
    public void asyncPublish(T event) {
        asyncBus.post(event);
    }
}
