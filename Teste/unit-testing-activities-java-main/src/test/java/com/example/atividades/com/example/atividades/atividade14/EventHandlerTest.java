package com.example.atividades.atividade14;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class EventHandlerTest {

    @Test
    public void testHandleEvent() {
        // Criar um mock de EmailService
        EmailService emailServiceMock = mock(EmailService.class);

        // Criar uma instância de EventHandler com o mock EmailService
        EventHandler eventHandler = new EventHandler(emailServiceMock);

        // Chamar o método a ser testado
        String event = "Some event";
        eventHandler.handleEvent(event);

        // Verificar se o método sendEmail foi chamado corretamente com os parâmetros esperados
        verify(emailServiceMock).sendEmail("test@example.com", "Event Occurred", event);
    }
}
