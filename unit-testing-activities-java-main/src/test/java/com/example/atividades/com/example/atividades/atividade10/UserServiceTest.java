package com.example.atividades.atividade10;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Test
    public void testGetUserInfo_UserExists() {
        // Criar uma instância do serviço
        UserService userService = new UserService();

        // Simular o comportamento do serviço externo
        User expectedUser = new User("John Doe", "john.doe@example.com");
        int userId = 123;
        when(userService.getUserInfo(userId)).thenReturn(expectedUser);

        // Chamar o método a ser testado
        User actualUser = userService.getUserInfo(userId);

        // Verificar se o usuário retornado é o esperado
        assertEquals(expectedUser, actualUser);
    }

    @Test
    public void testGetUserInfo_UserNotFound() {
        // Criar uma instância do serviço
        UserService userService = new UserService();

        // Simular o comportamento do serviço externo
        int userId = 456;
        when(userService.getUserInfo(userId)).thenReturn(null);

        // Chamar o método a ser testado e verificar se uma exceção é lançada
        assertThrows(RuntimeException.class, () -> {
            userService.getUserInfo(userId);
        });
    }
}
