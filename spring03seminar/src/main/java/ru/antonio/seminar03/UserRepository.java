package ru.antonio.seminar03;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class UserRepository {

    private List <User> users = new ArrayList<>();

    public void addRepo (User user) {
        users.add(user);
    }

    public List <User> getAllUsers (){
        return new ArrayList<>(users);
    }

    public User getUserById (UUID id){
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    public User getUserByName (String name){
        return users.stream().filter(user -> user.getName().equals(name)).findFirst().orElse(null);
    }

    public User getUserByAge (int age){
        return users.stream().filter(user -> user.getAge() ==age).findFirst().orElse(null);
    }

}
