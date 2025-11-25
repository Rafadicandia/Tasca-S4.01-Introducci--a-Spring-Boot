package cat.itacademy.s04.t01.userapi.controllers;

import cat.itacademy.s04.t01.userapi.Status;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class UserController {
    private ArrayList<String> users;

    public UserController() {
        this.users = new ArrayList<>();
    }

    @GetMapping("/users")
    public ArrayList<String> getUsers() {

        return users;
    }







}
