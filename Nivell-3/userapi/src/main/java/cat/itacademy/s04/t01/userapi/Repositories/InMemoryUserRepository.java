package cat.itacademy.s04.t01.userapi.Repositories;

import cat.itacademy.s04.t01.userapi.Interfaces.UserRepository;
import cat.itacademy.s04.t01.userapi.models.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
        } else  {
            userHashMap.replace(user.getId(), user);
            return user;
        }
    }

    @Override
    public List<User> findAll() {
        return List.of();
    }

    @Override
    public Optional<User> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<User> searchByName(String name) {
        return List.of();
    }

    @Override
    public boolean existsByEmail(String email) {
        return false;
    }
}
