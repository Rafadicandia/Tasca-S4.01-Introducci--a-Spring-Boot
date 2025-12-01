package cat.itacademy.s04.t01.userapi.controllers;

import cat.itacademy.s04.t01.userapi.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    private User testUser;

    @BeforeEach
    void setup() {
        testUser = new User(null, "Test", "test@test.com");
    }


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void getUsers_returnsEmptyListInitially() throws Exception {


        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));

    }

    @Test
    void createUser_returnsUserWithId() throws Exception {

        String userJson = objectMapper.writeValueAsString(testUser); // Serializar a JSON

        String responseJson = mockMvc.perform(MockMvcRequestBuilders.post("/users")
                        .contentType("application/json")
                        .content(userJson))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn().getResponse().getContentAsString();

        User createdUser = objectMapper.readValue(responseJson, User.class);

        assert (createdUser.getId() != null);

        assert (createdUser.getName().equals(testUser.getName()));
        assert (createdUser.getEmail().equals(testUser.getEmail()));


    }

    @Test
    void getUserById_returnsCorrectUser() throws Exception {

        String userJson = objectMapper.writeValueAsString(testUser); // Serializar a JSON

        String responseJson = mockMvc.perform(MockMvcRequestBuilders.post("/users")
                        .contentType("application/json")
                        .content(userJson))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn().getResponse().getContentAsString();

        User createdUser = objectMapper.readValue(responseJson, User.class);

        assert (createdUser.getId() != null);

        String userIdString = createdUser.getId().toString();

        String getResponseJson = mockMvc.perform(MockMvcRequestBuilders.get("/users/{id}", userIdString))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn().getResponse().getContentAsString();

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{id}", userIdString))
                .andExpect(status().isOk())
                .andExpect(content().json(responseJson));


    }


    @Test
    void getUserById_returnsNotFoundIfMissing() throws Exception {

        UUID testId = UUID.randomUUID();
        String userIdString = testId.toString();

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{id}", testId))
                .andExpect(status().isNotFound())
        ;
    }

    @Test
    void getUsers_withNameParam_returnsFilteredUsers() throws Exception {

        User userTest2 = new User(null, "Jo", "jo@gmail.com");

        String userJson = objectMapper.writeValueAsString(testUser);
        String userJson2 = objectMapper.writeValueAsString(userTest2);

        String responseJson = mockMvc.perform(MockMvcRequestBuilders.post("/users")
                        .contentType("application/json")
                        .content(userJson))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn().getResponse().getContentAsString();

        String responseJson2 = mockMvc.perform(MockMvcRequestBuilders.post("/users")
                        .contentType("application/json")
                        .content(userJson2))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn().getResponse().getContentAsString();

        User createdUser = objectMapper.readValue(responseJson, User.class);
        User createdUser2 = objectMapper.readValue(responseJson2, User.class);

        assert (createdUser.getId() != null);
        assert (createdUser2.getId() != null);

        String expectedFilteredJson = objectMapper.writeValueAsString(Collections.singletonList(createdUser2));


        mockMvc.perform(MockMvcRequestBuilders.get("/users")
                        .param("name", createdUser2.getName()))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(expectedFilteredJson));
    }
}


