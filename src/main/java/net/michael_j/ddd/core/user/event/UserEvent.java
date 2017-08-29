package net.michael_j.ddd.core.user.event;

import net.michael_j.ddd.core.event.DomainEvent;

/**
 * user event
 * Created by Michael Jiang on 16/1/12.
 */
public class UserEvent extends DomainEvent {
    private String name;
    private int age;
    private UserEventType type;

    public UserEvent(String name, UserEventType type) {
        this.name = name;
        this.type = type;
    }

    public UserEvent(String name, int age, UserEventType type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public UserEventType getType() {
        return type;
    }

    @Override
    protected String identify() {
        return "user_event";
    }

    @Override
    public String toString() {
        return "UserEvent{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", type=" + type +
                '}';
    }
}
