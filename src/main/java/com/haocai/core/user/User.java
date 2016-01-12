package com.haocai.core.user;

import org.springframework.stereotype.Service;

/**
 * Created by Michael Jiang on 16/1/12.
 */
public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        setName(name);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
