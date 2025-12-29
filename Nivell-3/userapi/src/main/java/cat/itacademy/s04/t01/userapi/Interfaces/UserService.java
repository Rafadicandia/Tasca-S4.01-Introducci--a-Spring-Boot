package cat.itacademy.s04.t01.userapi.Interfaces;

import cat.itacademy.s04.t01.userapi.models.User;
import cat.itacademy.s04.t01.userapi.models.UserRequestForNewUser;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    User save(UserRequestForNewUser userRequest);
    List<User> findAll();
    Optional<User> findById(UUID id);
    List<User> searchByName(String name);
    boolean existsByEmail(String email);
}
