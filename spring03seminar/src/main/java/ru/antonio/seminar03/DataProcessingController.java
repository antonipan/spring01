package ru.antonio.seminar03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DataProcessingController {

    private final DataProcessingService dataProcessingService;

    @Autowired
    public DataProcessingController(DataProcessingService dataProcessingService) {
        this.dataProcessingService = dataProcessingService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<User> addUsers () {
        return new ResponseEntity<>()
    }


}
