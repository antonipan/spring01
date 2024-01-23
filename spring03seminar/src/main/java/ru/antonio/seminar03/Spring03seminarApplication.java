package ru.antonio.seminar03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Часть 1
 * Создать сервис "DataProcessingService".
 * Этот сервис должен принимать на вход список объектов типа User (с полями "name", "age", "email"),
 * и выполнять следующие операции: сортировка списка пользователей по возрасту, фильтрация списка по заданному критерию
 * (например, возраст больше 18),
 * рассчет среднего возраста пользователей.
 *
 * Часть 2
 * Создать два сервиса - "DataProcessingService" и "NotificationService".
 * DataProcessingService должен содержать метод createUser(Stringname, int age, String email),
 * который создает пользователя и возвращает его.
 * NotificationService должен иметь метод notifyUser(User user),
 * который просто печатает сообщение о том, что пользователь был создан.
 * Ваша задача - использовать @Autowired в DataProcessingService для внедрения
 * NotificationService и вызвать метод notifyUserпосле создания нового пользователя.
 *
 * Часть 3
 * Создать сервис "RegistrationService", который принимает на вход данные о пользователе (имя, возраст, email),
 * создает пользователя с помощью UserService, затем использует DataProcessingService
 * для добавления пользователя в список и выполнения операций над этим списком. После выполнения каждой операции,
 * использовать NotificationService для вывода информации о выполненной операции.
 */



@SpringBootApplication
public class Spring03seminarApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring03seminarApplication.class, args);
	}

}
