package com.joseproyecto.jose.dao.impl;

import com.joseproyecto.jose.dao.UserDAO;
import com.joseproyecto.jose.model.User;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> findAll() {
        
        Session currentSession = entityManager.unwrap(Session.class);
        Query<User> theQuery = currentSession.createQuery("from User", User.class);
        List<User> users = theQuery.getResultList();

        return users;
    }

    @Override
    public User findById(int id) {
        
        Session currentSession = entityManager.unwrap(Session.class);
        User user = currentSession.get(User.class, id);

        return user;
    }

    @Override
    public void save(User user) {
        
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(user);
    }

    @Override
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<User> theQuery = currentSession.createQuery("delete from User where id=:idUser");
        theQuery.setParameter("idUser", id);
        theQuery.executeUpdate();
    }
}