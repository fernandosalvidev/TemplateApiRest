package com.joseproyecto.jose.dao;

import com.joseproyecto.jose.model.User;
import java.util.List;

public interface UserDAO {

    //Listado de datos de la tabla user
    public List<User> findAll();

    //Obtener un registro de la tabla user
    public User findById(int id);

    //Guardar un registro de la tabla user
    public void save(User user);

    //Eliminar un registro de la tabla user
    public void deleteById(int id);
}
