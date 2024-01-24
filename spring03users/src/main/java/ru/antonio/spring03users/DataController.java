package ru.antonio.spring03users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class DataController {
    private DataProcessingService processingService;

    @Autowired
    public DataController(DataProcessingService processingService) {
        this.processingService = processingService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<List<User>> addAllUsersFromBody (@RequestBody List <User> list) {
        return new ResponseEntity<>(processingService.addallUser(list), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> showAllUsersFromBody () {
        return new ResponseEntity<>(processingService.getAllUser(), HttpStatus.OK);
    }


    @RequestMapping(value = "/sorted", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getSortedListUsers () {
        return new ResponseEntity<>(processingService.sortedAge(), HttpStatus.OK);
    }



    @RequestMapping(value = "/filter/{age}", method = RequestMethod.GET)
    public ResponseEntity<List<User>> filterByAge (@PathVariable("age") Integer age){
        return new ResponseEntity<>(processingService.filtredAge(age), HttpStatus.OK);
    }

    @RequestMapping(value = "/average", method = RequestMethod.GET)
    public ResponseEntity<String> getAverAgeUsers() {
        return new ResponseEntity<>("Средний возраст: " + processingService.middleAge(), HttpStatus.OK);
    }
}
