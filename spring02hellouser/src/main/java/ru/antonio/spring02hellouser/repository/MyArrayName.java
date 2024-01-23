package ru.antonio.spring02hellouser.repository;

import org.springframework.stereotype.Component;

@Component
public class MyArrayName {

    public String [] names = new String[] {"Антон", "Богдан", "Николай", "Кирилл"};

    public String findByName (String name) {
        for (int i = 0; i < names.length; i++) {
            if(names[i].equals(name)){
                return "Имя " + names[i] + " найдено";
            }
        }
        return name + " такого имени нет . ";
    }
}
