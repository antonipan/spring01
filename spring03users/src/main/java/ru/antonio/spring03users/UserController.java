package ru.antonio.spring03users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user/reg")
public class UserController {

    private final RegistrationService registrationService;
    @Autowired
    public UserController (RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> registration (@RequestParam String name, @RequestParam int age, @RequestParam String email) {
        return new ResponseEntity<>(registrationService.registration(name, age, email), HttpStatus.CREATED);
    }
}
