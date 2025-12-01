package cat.itacademy.s04.t01.userapi.controllers;

import cat.itacademy.s04.t01.userapi.models.User;
import cat.itacademy.s04.t01.userapi.models.UserRequestForNewUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@RestController
public class UserController {
    private static ArrayList<User> users = new ArrayList<>();


    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(@RequestParam(name = "name", required = false) String name) {

        if (name == null || name.isEmpty()) {
            return ResponseEntity.ok(users);
        } else {
            String nameToLoweCase = name.toLowerCase();
            List<User> foundUser = users.stream().filter(users -> users.getName().toLowerCase().contains(nameToLoweCase)).toList();
            return ResponseEntity.ok(foundUser);
        }
    }

    @PostMapping("/users")
    public User createUser(@RequestBody UserRequestForNewUser user) {
        UUID uuid = randomUUID();
        User newUser = new User(uuid, user.getName(), user.getEmail());
        users.add(newUser);
        return newUser;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> readUser(@PathVariable(name = "id") UUID id) {
        User foundUser = users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);

        if (foundUser == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(foundUser);
        }
    }


}
