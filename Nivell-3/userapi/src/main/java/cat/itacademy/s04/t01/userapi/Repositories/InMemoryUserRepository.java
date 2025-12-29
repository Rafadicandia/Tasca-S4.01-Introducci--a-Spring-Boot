package cat.itacademy.s04.t01.userapi.Repositories;

import cat.itacademy.s04.t01.userapi.Interfaces.UserRepository;
import cat.itacademy.s04.t01.userapi.models.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Repository
public class InMemoryUserRepository implements UserRepository {
    private HashMap<UUID, User> userHashMap = new HashMap<>();


    @Override
    public User save(User user) {
        if (user.getId() == null) {
            UUID newId = UUID.randomUUID();
            User newUser = new User(newId, user.getName(), user.getEmail());
            userHashMap.put(newId, newUser);
            return newUser;
        } else {
            userHashMap.put(user.getId(), user);
            return user;
        }
    }

    @Override
    public List<User> findAll() {
        return List.copyOf(userHashMap.values());
    }

    @Override
    public Optional<User> findById(UUID id) {
        User foundid = userHashMap.get(id);
        return Optional.ofNullable(foundid);
    }

    @Override
    public List<User> searchByName(String name) {

        return userHashMap.values().stream()
                .filter(user -> user.getName().equalsIgnoreCase(name))
                .toList();
    }

    @Override
    public boolean existsByEmail(String email) {
        return userHashMap.values().stream()
                .filter(user -> user.getEmail() != null)
                .anyMatch(user -> user.getEmail().equalsIgnoreCase(email));
    }
}
