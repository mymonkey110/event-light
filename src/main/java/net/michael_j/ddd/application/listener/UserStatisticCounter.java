package net.michael_j.ddd.application.listener;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;
import net.michael_j.ddd.core.user.event.UserEvent;
import net.michael_j.ddd.core.user.event.UserEventPublisher;
import net.michael_j.ddd.core.user.event.UserEventType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Michael Jiang on 16/1/12.
 */
@Service
public class UserStatisticCounter {

    private AtomicLong registerCounter = new AtomicLong(0L);
    private AtomicLong loginCounter = new AtomicLong(0L);

    private static Logger LOG = LoggerFactory.getLogger(UserStatisticCounter.class);

    @Autowired
    public UserStatisticCounter(UserEventPublisher userEventPublisher) {
        userEventPublisher.register(this);
    }

    @Subscribe
    @AllowConcurrentEvents
    public void listenUserEvent(UserEvent userEvent) {
        if (userEvent.getType().equals(UserEventType.REGISTER)) {
            LOG.info("add a new user,name:{},age:{}. total register user:{}.",
                    userEvent.getName(), userEvent.getAge(), registerCounter.incrementAndGet());
        } else if (userEvent.getType().equals(UserEventType.LOGIN)) {
            LOG.info("user:{} login,all user total login times:{}.", userEvent.getName(), loginCounter.incrementAndGet());
        } else {
            throw new IllegalStateException("unknown user event type");
        }
    }
}
