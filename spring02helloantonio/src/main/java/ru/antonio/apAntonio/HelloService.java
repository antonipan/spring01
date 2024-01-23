package ru.antonio.apAntonio;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String greating () {
        return "waiting for a request in the console";
    }
}

