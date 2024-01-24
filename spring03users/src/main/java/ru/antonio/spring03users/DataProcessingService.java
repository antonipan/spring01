package ru.antonio.spring03users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {
    @Autowired
    private UserRepository userRepository;
    private NotificationService notificationService;

    public DataProcessingService (UserRepository userRepository,
                                  NotificationService notificationService) {
        this.userRepository = userRepository;
        this.notificationService = notificationService;
    }

    public List<User> addallUser (List <User> list) {
        return userRepository.addAllUsers(list);
    }

    public List<User> getAllUser () {
        return userRepository.findAll();
    }

    public List <User> sortedAge () {
        return userRepository.findAll().stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public List <User> filtredAge (int age) {
        return userRepository.findAll()
                .stream().filter(user -> user.getAge() >= age).collect(Collectors.toCollection(LinkedList::new));
    }

    public double middleAge () {
        return userRepository.findAll().stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }

    public User saveOneUser (User user) {
        notificationService.notifyAddedUserToRepo(user);
        return userRepository.saveUser(user);
    }
}
