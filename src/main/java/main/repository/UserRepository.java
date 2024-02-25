package main.repository;


import main.ForLogin;
import main.entity.User;

import java.util.List;

public interface UserRepository {
    void save(User entity);
    User getById(long id);
    void update(User entity, long id);
    void delete(long id);
    List<User> getAll();
    User login (ForLogin consol);
}
