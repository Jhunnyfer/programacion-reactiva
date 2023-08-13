package com.cedesistemas.reactive.controller;

import com.cedesistemas.reactive.model.Category;
import com.cedesistemas.reactive.model.Client;
import com.cedesistemas.reactive.service.CategoryService;
import com.cedesistemas.reactive.service.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ClientControllerTest {

    @InjectMocks
    ClientController clientController;

    @Mock
    ClientService clientService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void getAllClient() {
        Client client1 = new Client(1, 1, 123, "Carlos", "Puerta", "Calle 1", 1234);
        Client client2 = new Client(2, 1, 124, "Juan", "Serna", "Calle 2", 1234);
        Flux<Client> list = Flux.just(client1, client2);
        when(this.clientService.getAll()).thenReturn(list);
        Flux<Client> results = clientController.getAllClient();
        results.subscribe();
        assertEquals(list, results);
    }

    @Test
    void getIdClient() {
        Client client = new Client(1, 1, 123, "Carlos", "Puerta", "Calle 1", 1234);
        when(this.clientService.getByIdentification(1)).thenReturn(Mono.just(client));
        Mono<Client> result = clientController.getIdClient(1);
        assertEquals(client, result.block());
    }

    @Test
    void saveClient() {
        Client client = new Client(1, 1, 123, "Carlos", "Puerta", "Calle 1", 1234);
        when(this.clientService.save(client)).thenReturn(Mono.just(client));
        Mono<Client> result = clientController.saveClient(client);
        StepVerifier.create(result)
                .expectNext(client)
                .verifyComplete();

    }

    @Test
    void updateClient() {
        Client client = new Client(1, 1, 123, "Carlos", "Puerta", "Calle 1", 1234);
        when(this.clientService.update(123,client)).thenReturn(Mono.just(client));
        Mono<Client> result = clientController.updateClient(123,client);
        StepVerifier.create(result)
                .expectNext(client)
                .verifyComplete();
    }
}