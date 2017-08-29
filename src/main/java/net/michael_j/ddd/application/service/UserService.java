package net.michael_j.ddd.application.service;

import net.michael_j.ddd.core.user.event.LogoutEvent;
import net.michael_j.ddd.core.user.event.UserEvent;
import net.michael_j.ddd.core.user.event.UserEventPublisher;
import net.michael_j.ddd.core.user.event.UserEventType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * Created by Michael Jiang on 16/1/12.
 */
@Service
public class UserService implements ApplicationContextAware {
    private final UserEventPublisher userEventPublisher;

    private ApplicationContext applicationContext;

    private static Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    public UserService(UserEventPublisher userEventPublisher) {
        this.userEventPublisher = userEventPublisher;
    }

    public void register(String name, int age) {
        LOG.info("user:{} age:{} register done.", name, age);
        userEventPublisher.asyncPublish(new UserEvent(name, age, UserEventType.REGISTER));
    }

    public void login(String name) {
        LOG.info("user:{} login!", name);
        userEventPublisher.publish(new UserEvent(name, UserEventType.LOGIN));
    }

    public void logout(String name) {
        LOG.info("user:{} logout!", name);
        applicationContext.publishEvent(new LogoutEvent("user_service", name));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
