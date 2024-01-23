package ru.antonio.seminar03;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {

    UserRepository userRepository;

    public DataProcessingService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers () {
        return userRepository.getAllUsers();
    }

    public List <User> sortUserByAge () {
        return userRepository.getAllUsers().stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    public List <User> sortUserByName () {
        return userRepository.getAllUsers().stream()
                .sorted(Comparator.comparing(User::getName))
                .collect(Collectors.toList());
    }

    public List <User> sortUserByMail () {
        return userRepository.getAllUsers().stream()
                .sorted(Comparator.comparing(User::getName))
                .collect(Collectors.toList());
    }

    public List <User> filterByAge (int age) {
        return userRepository.getAllUsers().stream()
                .filter(user -> user.getAge() >= age)
                .collect(Collectors.toList());
    }

    public List <User> filterByAge (String name) {
        return userRepository.getAllUsers().stream()
                .filter(user -> user.getName().equals(name))
                .collect(Collectors.toList());
    }
}
