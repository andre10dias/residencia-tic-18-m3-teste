package com.example.atividades.atividade07;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

public class UserServiceTest {

    @Mock
    private Database mockDatabase;

    private UserService userService;

    private AutoCloseable closeable;

    @BeforeEach
    public void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
        userService = new UserService(mockDatabase);
    }

    @AfterEach
    public void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    public void testSaveUser_ValidUser() {
        User user = new User("John Doe", "john.doe@example.com");
        userService.saveUser(user);

        // Verifica se o método saveUser do Database foi chamado uma vez
        verify(mockDatabase, times(1)).saveUser(user);
    }

    @Test
    public void testSaveUser_NullName() {
        // Cria um usuário com nome nulo
        User user = new User(null, "john.doe@example.com");

        // Verifica se a exceção IllegalArgumentException é lançada
        assertThrows(IllegalArgumentException.class, () -> {
            userService.saveUser(user);
        });
    }

    @Test
    public void testSaveUser_EmptyName() {
        // Cria um usuário com nome vazio
        User user = new User("", "john.doe@example.com");

        // Verifica se a exceção IllegalArgumentException é lançada
        assertThrows(IllegalArgumentException.class, () -> {
            userService.saveUser(user);
        });
    }

    @Test
    public void testSaveUser_NullEmail() {
        // Cria um usuário com email nulo
        User user = new User("John Doe", null);

        // Verifica se a exceção IllegalArgumentException é lançada
        assertThrows(IllegalArgumentException.class, () -> {
            userService.saveUser(user);
        });
    }

    @Test
    public void testSaveUser_EmptyEmail() {
        // Cria um usuário com email vazio
        User user = new User("John Doe", "");

        // Verifica se a exceção IllegalArgumentException é lançada
        assertThrows(IllegalArgumentException.class, () -> {
            userService.saveUser(user);
        });
    }
}
