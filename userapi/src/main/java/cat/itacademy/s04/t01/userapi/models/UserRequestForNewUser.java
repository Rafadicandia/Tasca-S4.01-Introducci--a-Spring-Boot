package cat.itacademy.s04.t01.userapi.models;

public class UserRequestForNewUser {
    private String name;
    private String email;

    public UserRequestForNewUser(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }



    public String getEmail() {
        return email;
    }


}
