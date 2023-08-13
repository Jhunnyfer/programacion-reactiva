package com.cedesistemas.reactive.service;

import com.cedesistemas.reactive.model.Client;
import com.cedesistemas.reactive.repository.ClientRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientService {
    ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Mono<Client> save( Client client){
        return clientRepository.save(client);
    }

    public Mono<Client> update(Integer identificacion, Client client){
        client.setId(identificacion);
        return clientRepository.save(client);
    }

    public Flux<Client> getAll(){
        return clientRepository.findAll();
    }

    public Mono<Client> getById(Integer id){
        return clientRepository.findById(id);
    }

    public Mono<Client> getByIdentification(Integer identificacion){
        return clientRepository.findById(identificacion);
    }

    public Mono<Client> deleteClientByIdentification(Integer identification){
        Integer idClient = 1;
        Mono<Client> client = Mono.empty();
        clientRepository.deleteById(idClient);
        return client;
    }

}
