package com.haocai.core.event;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import java.util.concurrent.Executors;


/**
 * Guava事件发布器实现
 * Created by Michael Jiang on 16/1/12.
 */
public abstract class GuavaDomainEventPublisher implements DomainEventPublisher {
    private EventBus syncBus = new EventBus(identify());
    private EventBus asyncBus = new AsyncEventBus(identify(), Executors.newFixedThreadPool(1));

    @Override
    public void register(Object listener) {
        syncBus.register(listener);
        asyncBus.register(listener);
    }

    @Override
    public void publish(DomainEvent event) {
        syncBus.post(event);
    }

    @Override
    public void asyncPublish(DomainEvent event) {
        asyncBus.post(event);
    }

}
