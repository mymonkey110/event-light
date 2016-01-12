package com.haocai.core.event;

import java.util.Date;

/**
 * Created by Michael Jiang on 16/1/12.
 */
public abstract class DomainEvent {
    private Date occurredTime;

    protected abstract String identify();

    public DomainEvent() {
        occurredTime =new Date();
    }

    public Date getOccurredTime() {
        return occurredTime;
    }
}
