package com.haocai.core.user.event;

import com.haocai.core.event.GuavaDomainEventPublisher;
import org.springframework.stereotype.Service;

/**
 * Created by Michael Jiang on 16/1/12.
 */
@Service
public class UserEventPublisher extends GuavaDomainEventPublisher<UserEvent> {
    @Override
    public String identify() {
        return "user_event_publisher";
    }
}
