package ru.antonio.userservice;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;
@Component
public class UserService {

    private UserRepository userRepository;

    public UserService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers () {
        return userRepository.findAll();
    }

    public User getUserById (Long id) {
        return userRepository.findById(id);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
