package com.joseproyecto.jose.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.joseproyecto.jose.dao.UserDAO;
import com.joseproyecto.jose.model.User;
import com.joseproyecto.jose.service.UserService;
import java.util.List;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> findAll() {
        List<User> listUsers= userDAO.findAll();
        return listUsers;
    }

    @Override
    public User findById(int id) {
        User user = userDAO.findById(id);
        return user;
    }

    @Override
    public void save(User user) {
        userDAO.save(user);

    }

    @Override
    public void deleteById(int id) {
        userDAO.deleteById(id);
    }
}
