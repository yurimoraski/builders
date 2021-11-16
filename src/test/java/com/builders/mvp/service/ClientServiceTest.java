package com.builders.mvp.service;

import com.builders.mvp.domain.Client;
import com.builders.mvp.repository.ClientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.builders.mvp.helper.MockHelper.getClientMock;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {

    @Mock
    private ClientRepository repository;

    @InjectMocks
    private ClientService service;

    @BeforeEach
    void init() {
        service = new ClientService(repository);
    }

    @Test
    void when_get_present_client_then_return_client() {
        Client clientMock = getClientMock();

        when(repository.findById(any(String.class))).thenReturn(Optional.of(clientMock));

        var response = service.findOne("2319");

        Assertions.assertEquals(clientMock, response);
    }



}
