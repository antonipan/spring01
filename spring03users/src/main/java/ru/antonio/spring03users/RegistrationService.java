package ru.antonio.spring03users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private UserService userService;
    private DataProcessingService processingService;
    private NotificationService notificationService;

    @Autowired
    public RegistrationService (UserService userService,
                                DataProcessingService processingService,
                                NotificationService notificationService) {
        this.userService = userService;
        this.processingService = processingService;
        this.notificationService = notificationService;
    }

    public User registration (String name, int age, String email) {
        User user = userService.createUser(name, age, email);
        processingService.saveOneUser(user);
        notificationService.notifyRegistrationUser(user);
        return user;
    }
}
