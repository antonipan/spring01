package ru.antonio.spring04sem;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomService {

    private Random random = new Random();

    public Integer generatedRandom () {
        return random.nextInt(1, 101);
    }
}
