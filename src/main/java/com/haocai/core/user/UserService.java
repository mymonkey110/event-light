package com.haocai.core.user;

import com.haocai.core.user.event.UserEvent;
import com.haocai.core.user.event.UserEventPublisher;
import com.haocai.core.user.event.UserEventType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Michael Jiang on 16/1/12.
 */
@Service
public class UserService {
    @Autowired
    private UserEventPublisher userEventPublisher;

    private static Logger LOG = LoggerFactory.getLogger(UserService.class);

    public void register(String name, int age) {
        LOG.info("user:{} age:{} register done.", name, age);
        userEventPublisher.asyncPublish(new UserEvent(name, age, UserEventType.REGISTER));
    }

    public void login(String name) {
        LOG.info("user:{} login!",name);
        userEventPublisher.publish(new UserEvent(name,UserEventType.LOGIN));
    }
}
