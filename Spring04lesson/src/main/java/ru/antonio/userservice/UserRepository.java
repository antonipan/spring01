package ru.antonio.userservice;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class UserRepository {

    private Map<Long, User> users = new ConcurrentHashMap<>();
    private AtomicLong counter = new AtomicLong();

    public UserRepository () {
        users.put(counter.incrementAndGet(), new User(counter.longValue(), "Igor", "igor@mail.ru"));
        users.put(counter.incrementAndGet(), new User(counter.longValue(), "Ralf", "ralf@mail.com"));
        users.put(counter.incrementAndGet(), new User(counter.longValue(), "Max", "max@false.tru"));

    }

    public List <User> findAll () {
        return new ArrayList<>(users.values());
    }

    public User findById (Long id) {
        return users.get(id);
    }

    public User save (User user ) {
        if(user.getId() == null) {
            user.setId(counter.incrementAndGet());
        }
        users.put(user.getId(), user);
        return user;
    }
}
