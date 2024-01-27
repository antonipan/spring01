package ru.antonio.spring04sem;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class RandomController {

    private RandomService randomService;

    public RandomController (RandomService randomService) {
        this.randomService = randomService;
    }

    @GetMapping("/ran")
    public String generatedRanNum (Model model) {
        model.addAttribute("num", randomService.generatedRandom());
        return "random";
    }
}
