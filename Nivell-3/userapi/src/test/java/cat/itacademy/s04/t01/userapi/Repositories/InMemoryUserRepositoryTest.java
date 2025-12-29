package cat.itacademy.s04.t01.userapi.Repositories;

import cat.itacademy.s04.t01.userapi.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

class InMemoryUserRepositoryTest {
    private User testUser;
    private InMemoryUserRepository repository;
    private UUID testId;

    @BeforeEach
    void setup() {
        repository = new InMemoryUserRepository();
        testId = UUID.randomUUID();
        testUser = new User(testId, "Test User", "test@test.com");
        repository.save(testUser);
    }
    
    @Test
    void save() {
        User newUser = new User(UUID.randomUUID(), "New User", "new@test.com");
        repository.save(newUser);

        Optional<User> saved = repository.findById(newUser.getId());
        assertTrue(saved.isPresent());
        assertEquals("New User", saved.get().getName());
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