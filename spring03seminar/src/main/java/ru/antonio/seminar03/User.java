package ru.antonio.seminar03;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class User {

    private UUID id;
    private String name;
    private int age;
    private String email;

    public User(String name, int age, String email) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
