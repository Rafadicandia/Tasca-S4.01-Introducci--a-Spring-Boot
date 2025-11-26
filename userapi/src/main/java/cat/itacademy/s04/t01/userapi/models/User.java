package cat.itacademy.s04.t01.userapi.models;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


public class User {
    private UUID id;
    private String name;
    private String email;

    public User(UUID id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }


    public String getName() {
        return name;
    }



    public String getEmail() {
        return email;
    }


}
