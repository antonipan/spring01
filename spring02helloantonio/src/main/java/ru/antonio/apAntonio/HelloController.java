package ru.antonio.apAntonio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final HelloService helloService;
    private final GoodBuyService goodBuyService;

    @Autowired
    public HelloController (HelloService helloService, GoodBuyService goodBuyService) {
        this.helloService = helloService;
        this.goodBuyService = goodBuyService;
    }

    @GetMapping("/")
    public String hello (){
        return this.helloService.greating();
    }

    @GetMapping("/{id}")
    public String goodbuy () {
        return this.goodBuyService.getGoodBuy();
    }
}
