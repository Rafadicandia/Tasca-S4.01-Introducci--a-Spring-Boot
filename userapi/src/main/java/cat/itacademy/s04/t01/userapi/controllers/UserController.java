package cat.itacademy.s04.t01.userapi.controllers;

import cat.itacademy.s04.t01.userapi.models.User;
import cat.itacademy.s04.t01.userapi.models.UserRequestForNewUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class UserController {
    private static ArrayList<User> users =  new ArrayList<>();;


    @GetMapping("/users")
    public ArrayList<User> getUsers() {

        return users;
    }

    @PostMapping("/users")
    public User createUser(@RequestBody UserRequestForNewUser user){

        User newUser = new User();
        return newUser;
    }


}
