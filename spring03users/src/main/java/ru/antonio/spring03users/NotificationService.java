package ru.antonio.spring03users;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void notifyCreateUser(User user) {
        System.out.println("A new user has been created: " + user.getName());
    }

    public void notifyAddedUserToRepo (User user) {
        System.out.println("The User " + user.getName() + " append to repository... ");
    }

    public void notifyRegistrationUser (User user) {
        System.out.println("The User " + user.getName() + " has successfully registered");
    }
}
