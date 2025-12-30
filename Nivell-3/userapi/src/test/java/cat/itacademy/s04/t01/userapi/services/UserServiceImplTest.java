package cat.itacademy.s04.t01.userapi.services;

import cat.itacademy.s04.t01.userapi.Interfaces.UserRepository;
import cat.itacademy.s04.t01.userapi.exceptions.EmailAlreadyExistsException;
import cat.itacademy.s04.t01.userapi.models.User;
import cat.itacademy.s04.t01.userapi.models.UserRequestForNewUser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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

        EmailAlreadyExistsException emailAlreadyExistsException = assertThrowsExactly(
                EmailAlreadyExistsException.class, () -> userService.save(userRequest));

        assertEquals("Email already exist", emailAlreadyExistsException.getMessage());

        verify(userRepository, never()).save(any(User.class));

    }

    @Test
    @DisplayName("Should save new user when Email is not registered")
    void createUser_shouldSaveNewUserWhenEmailIsNotRegistered() {
        UserRequestForNewUser userRequest = new UserRequestForNewUser("Pepito", "pepito@gmail.com");

        when(userRepository.existsByEmail(userRequest.getEmail())).thenReturn(false);

        when(userRepository.save(any(User.class))).thenAnswer(i -> i.getArguments()[0]);

        User registeredUser = userService.save(userRequest);

        assertNotNull(registeredUser.getId());
        assertEquals("Pepito", registeredUser.getName());
        assertEquals("pepito@gmail.com", registeredUser.getEmail());

        verify(userRepository, times(1)).save(any(User.class));


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