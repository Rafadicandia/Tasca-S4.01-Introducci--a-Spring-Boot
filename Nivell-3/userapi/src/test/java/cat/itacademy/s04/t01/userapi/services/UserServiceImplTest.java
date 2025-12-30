package cat.itacademy.s04.t01.userapi.services;

import cat.itacademy.s04.t01.userapi.Interfaces.UserRepository;
import cat.itacademy.s04.t01.userapi.models.UserRequestForNewUser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    @DisplayName("Should throw exception when Email is already exists")
    void createUser_shouldThrowExceptionWhenEmailAlreadyExists() {
        UserRequestForNewUser userRequest = new UserRequestForNewUser("Pepito", "pepito@gmail.com");
        when(userRepository.existsByEmail(userRequest.getEmail())).thenReturn(true);

        

    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void searchByName() {
    }

    @Test
    void existsByEmail() {
    }
}