package ru.antonio.spring02hellouser.repository;

import ru.antonio.spring02hellouser.model.User;

import java.util.List;


public interface Repozitory {
    List<User> unload ();

    String findToName (String name, List <User> users);
}
