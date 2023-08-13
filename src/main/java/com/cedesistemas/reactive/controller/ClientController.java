package com.cedesistemas.reactive.controller;


import com.cedesistemas.reactive.model.Client;
import com.cedesistemas.reactive.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    ClientService clientService;


    @GetMapping("/")
    public Flux<Client> getAllClient(){
        return  clientService.getAll();
    }

    @GetMapping("/{id}")
    public Mono<Client> getIdClient(@PathVariable Integer identification){
        return clientService.getByIdentification(identification);
    }

    @PostMapping("/")
    public Mono<Client> saveClient(@RequestBody Client client){
        return clientService.save(client);
    }

    @PutMapping("/{id}")
    public Mono<Client> updateClient(@PathVariable Integer identification, @RequestBody Client client){
        return clientService.update(identification, client);
    }

}
