package cat.itacademy.s04.t01.userapi.controllers;

import cat.itacademy.s04.t01.userapi.models.User;
import cat.itacademy.s04.t01.userapi.models.UserRequestForNewUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@RestController
public class UserController {
    private static ArrayList<User> users =  new ArrayList<>();;


    @GetMapping("/users")
    public ArrayList<User> getUsers() {

        return users;
    }

    @PostMapping("/users")
    public User createUser(@RequestBody UserRequestForNewUser user){

        UUID uuid = randomUUID();

        User newUser = new User(uuid, user.getName(), user.getEmail());
        users.add(newUser);

        return newUser;
    }


}
