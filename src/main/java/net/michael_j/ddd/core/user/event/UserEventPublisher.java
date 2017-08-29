package net.michael_j.ddd.core.user.event;

import net.michael_j.ddd.core.event.GuavaDomainEventPublisher;
import org.springframework.stereotype.Service;

/**
 * 用户事件发布器
 * Created by Michael Jiang on 16/1/12.
 */
@Service
public class UserEventPublisher extends GuavaDomainEventPublisher {
    @Override
    public String identify() {
        return "user_event_publisher";
    }
}
