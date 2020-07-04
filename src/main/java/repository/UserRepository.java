package repository;

import model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class UserRepository {

    private static UserRepository userRepository;

    public static UserRepository getInstance() {
        if (userRepository == null) {
            userRepository = new UserRepository();
        }
        return userRepository;
    }

    private List<User> users;

    private UserRepository() {
        users = new ArrayList<>();
    }

    public boolean existsByLogin(String login) {
        return users.stream().anyMatch(u -> u.getLogin().equalsIgnoreCase(login));
    }

    public void save(User user) {
        users.add(user);
    }

    public List<User> findAll() {
        return Collections.unmodifiableList(users);
    }

    public Optional<User> findByLoginAndPassword(String login, String password) {
        return users.stream()
                .filter(u -> u.getLogin().equals(login) && u.getPassword().equals(password))
                .findFirst();
    }

    public void deleteUser(String login) {
        Optional<User> userOptional = users.stream()
                .filter(u -> u.getLogin().equals(login))
                .findFirst();
        userOptional.ifPresent(value -> users.remove(value));
    }
}
