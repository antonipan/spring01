package ru.antonio.spring03users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private NotificationService notificationService;

    @Autowired
    public UserService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
    public User createUser (String name, int age, String email) {
        User user = new User(name, age, email);

        notificationService.notifyCreateUser(user);

        return user;
    }
}
