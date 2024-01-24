package ru.antonio.spring03users;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
@Service
public class UserRepository {

    private final List<User> users = new LinkedList<>();


    public List<User> findAll () {
        return users;
    }

    public List<User> addAllUsers (List <User> list) {
        this.users.addAll(list);
        return users;
    }


    public User saveUser (User user) {
        users.add(user);
        return user;
    }




}
