package ru.antonio.spring02hellouser.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.antonio.spring02hellouser.model.User;
import ru.antonio.spring02hellouser.repository.MyArrayName;
import ru.antonio.spring02hellouser.repository.MyDataBase;

import java.util.Arrays;
import java.util.List;

@RestController
public class ControllerHelloUser {

    private List <User> users;
    private final MyDataBase myDataBase;
    private final MyArrayName myArrayName;

    public ControllerHelloUser(List<User> users, MyDataBase myDataBase, MyArrayName myArrayName) {
        this.users = users;
        this.myDataBase = myDataBase;
        this.myArrayName = myArrayName;
    }

    @GetMapping("/")
    public String helloUser () {
        return "Здравствуйте. Загружается база данных с именами";
    }

    @GetMapping("/{name}")
    public String getUserName (@PathVariable String name) {
//        users = myDataBase.unload();
//        myDataBase.findToName(name, users);
        return myArrayName.findByName(name);
    }

    @GetMapping("/names")
    public String getUserNameDB () {
        return Arrays.toString(myDataBase.unload().toArray());
    }
}
