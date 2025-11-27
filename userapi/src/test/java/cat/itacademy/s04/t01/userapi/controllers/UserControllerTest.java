package cat.itacademy.s04.t01.userapi.controllers;

import cat.itacademy.s04.t01.userapi.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(UserController.class)
class UserControllerTest {

    private User testUser;

    @BeforeEach
    void setup() {
        UUID testId = UUID.randomUUID();
        testUser = new User(testId, "Test", "test@test.com");
    }


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void getUsers_returnsEmptyListInitially() throws Exception {
        // Simula GET /users
        // Espera un array buit

        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));

    }

    @Test
    void createUser_returnsUserWithId() throws Exception {
        // Simula POST /users amb JSON
        // Espera que torni el mateix usuari amb UUID no nul

        String userJson = objectMapper.writeValueAsString(testUser); // Serializar a JSON

        String responseJson = mockMvc.perform(MockMvcRequestBuilders.post("/users")
                        .contentType("application/json")
                        .content(userJson)) // ENVIAR el cuerpo JSON del usuario
                .andExpect(status().isOk()) // Esperar 201 Created
                .andExpect(content().contentType("application/json"))
                .andReturn().getResponse().getContentAsString();

        User createdUser = objectMapper.readValue(responseJson, User.class);


        assert (createdUser.getId() != null);


    }

    @Test
    void getUserById_returnsCorrectUser() throws Exception {
        // Primer afegeix un usuari amb POST
        // Després GET /users/{id} i comprova que torni aquest usuari


    }


    @Test
    void getUserById_returnsNotFoundIfMissing() {
        // Simula GET /users/{id} amb un id aleatori
        // Espera 404
    }

    @Test
    void getUsers_withNameParam_returnsFilteredUsers() {
        // Afegeix dos usuaris amb POST
        // Fa GET /users?name=jo i comprova que només torni els que contenen "jo"
    }
}


