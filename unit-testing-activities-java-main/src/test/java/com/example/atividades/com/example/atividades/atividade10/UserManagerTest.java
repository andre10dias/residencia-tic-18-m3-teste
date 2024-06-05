package com.example.atividades.atividade10;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class UserManagerTest {

    @Test
    public void testFetchUserInfo_UserExists() {
        // Criar um mock para UserService
        UserService userService = mock(UserService.class);

        // Configurar o comportamento do mock
        User expectedUser = new User("John Doe", "john.doe@example.com");
        int userId = 123;
        when(userService.getUserInfo(userId)).thenReturn(expectedUser);

        // Criar uma instância do UserManager com o mock UserService
        UserManager userManager = new UserManager(userService);

        // Chamar o método a ser testado
        User actualUser = userManager.fetchUserInfo(userId);

        // Verificar se o usuário retornado é o esperado
        assertEquals(expectedUser, actualUser);
    }

    @Test
    public void testFetchUserInfo_UserNotFound() {
        // Criar um mock para UserService
        UserService userService = mock(UserService.class);

        // Configurar o comportamento do mock
        int userId = 456;
        when(userService.getUserInfo(userId)).thenReturn(null);

        // Criar uma instância do UserManager com o mock UserService
        UserManager userManager = new UserManager(userService);

        // Chamar o método a ser testado e verificar se uma exceção é lançada
        assertThrows(RuntimeException.class, () -> {
            userManager.fetchUserInfo(userId);
        });
    }
}
