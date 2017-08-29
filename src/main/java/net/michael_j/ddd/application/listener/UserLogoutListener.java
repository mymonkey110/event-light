package net.michael_j.ddd.application.listener;

import net.michael_j.ddd.core.user.event.LogoutEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * Created by Michael Jiang on 16/1/13.
 */
@Service
public class UserLogoutListener implements ApplicationListener<LogoutEvent> {

    private static Logger LOG = LoggerFactory.getLogger(UserLogoutListener.class);

    @Override
    public void onApplicationEvent(LogoutEvent event) {
        LOG.info("user:{} logout!", event.getName());
    }
}
