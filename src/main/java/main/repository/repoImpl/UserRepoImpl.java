package main.repository.repoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import main.ForLogin;
import main.entity.User;
import main.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class UserRepoImpl implements UserRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public void save(User entity) {
        entityManager.persist(entity);
    }

    @Override
    public User getById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void update(User entity, long id) {
        User user = getById(id);
        user.setUserName(entity.getUserName());
        user.setEmail(entity.getEmail());
        user.setPassword(entity.getPassword());
        user.setPhoneNumber(entity.getPhoneNumber());
        entityManager.merge(user);
    }

    @Override
    public void delete(long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public List<User> getAll() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User login(ForLogin consol) {
        User user1 = null;
        for (User user : getAll()) {
            if (user.getPhoneNumber().equals(consol.getPhoneNumber()) && user.getPassword().equals(consol.getPassword())) {
                user1 = user;
            }
        }
        return user1;
    }

}
