package main.service.servImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import main.ForLogin;
import main.entity.User;
import main.repository.UserRepository;
import main.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class UserServImpl implements UserService {
    private final UserRepository userRepository;


    @Override
    public void save(User entity) {
        userRepository.save(entity);
    }

    @Override
    public User getById(long id) {
        return userRepository.getById(id);
    }

    @Override
    public void update(User entity, long id) {
        userRepository.update(entity, id);
    }

    @Override
    public void delete(long id) {
        userRepository.delete(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public User login(ForLogin console) {
        return userRepository.login(console);
    }
}
