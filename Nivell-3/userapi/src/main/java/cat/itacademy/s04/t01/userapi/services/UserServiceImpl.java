package cat.itacademy.s04.t01.userapi.services;

import cat.itacademy.s04.t01.userapi.Interfaces.UserRepository;
import cat.itacademy.s04.t01.userapi.Interfaces.UserService;
import cat.itacademy.s04.t01.userapi.exceptions.EmailAlreadyExistsException;
import cat.itacademy.s04.t01.userapi.exceptions.UserNotFoundException;
import cat.itacademy.s04.t01.userapi.models.User;
import cat.itacademy.s04.t01.userapi.models.UserRequestForNewUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User save(UserRequestForNewUser userRequest) {
        if (userRepository.existsByEmail(userRequest.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exist");
        }
        UUID uuid = randomUUID();
        User newUser = new User(uuid, userRequest.getName(), userRequest.getEmail());
        return userRepository.save(newUser);

    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(UUID id) {
        return Optional.ofNullable(userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User doesn't exists")));
    }

    @Override
    public List<User> searchByName(String name) {
        return userRepository.searchByName(name);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
