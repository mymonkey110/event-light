package net.michael_j.ddd.core.user.event;

import org.springframework.context.ApplicationEvent;

/**
 * user logout event
 * Created by Michael Jiang on 16/1/13.
 */
public class LogoutEvent extends ApplicationEvent {
    private String name;

    public LogoutEvent(Object source, String name) {
        super(source);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "LogoutEvent{" +
                "name='" + name + '\'' +
                '}';
    }
}
