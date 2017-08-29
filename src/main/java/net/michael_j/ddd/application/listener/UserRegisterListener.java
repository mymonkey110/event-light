package net.michael_j.ddd.application.listener;

import com.google.common.eventbus.Subscribe;
import net.michael_j.ddd.core.user.event.UserEvent;
import net.michael_j.ddd.core.user.event.UserEventPublisher;
import net.michael_j.ddd.core.user.event.UserEventType;
import net.michael_j.ddd.infrastructure.email.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Michael Jiang on 16/1/12.
 */
@Service
public class UserRegisterListener {
    @Resource
    private EmailSender emailSender;

    @Autowired
    public UserRegisterListener(UserEventPublisher userEventPublisher) {
        userEventPublisher.register(this);
    }

    @Subscribe
    public void listenUserRegisterEvent(UserEvent userEvent) {
        if (userEvent.getType().equals(UserEventType.REGISTER)) {
            emailSender.send(userEvent.getName(), "welcome to join us!");
        }
    }
}
