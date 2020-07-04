package service;

import model.User;
import repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserService {

    private static UserService userService;

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    private UserRepository repository;

    private UserService() {
        repository = UserRepository.getInstance();
    }

    public boolean existByLogin(String login) {
        return repository.existsByLogin(login);
    }

    public void save(User user) {
        repository.save(user);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public Optional<User> findUserByLoginAndPassword(String login, String password) {
        return repository.findByLoginAndPassword(login, password);
    }


    public void deleteUser(String login) {
        repository.deleteUser(login);
    }
}
