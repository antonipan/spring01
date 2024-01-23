package ru.antonio.spring02hellouser.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.antonio.spring02hellouser.model.User;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


@Component
public class MyDataBase implements Repozitory{
    Session session;
    SessionFactory sessionFactory;

    public MyDataBase () {


    }

    @Override
    public List <User> unload() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
        session = sessionFactory.getCurrentSession();
        try {
            CriteriaBuilder cb = session.getCriteriaBuilder();

            CriteriaQuery<User> cq = cb.createQuery(User.class);
            Root<User> rootEntry = cq.from(User.class);
            CriteriaQuery<User> all = cq.select(rootEntry);

            TypedQuery<User> allQuery = session.createQuery(all);
            return allQuery.getResultList();
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String findToName (String name, List <User> users) {
//        for (User user : users
//        ) {
//            if (user.getName().equals(name)) {
//                return user.toString();
//            }
//        }
        return "Нет такого пользователя... ";
    }
}
