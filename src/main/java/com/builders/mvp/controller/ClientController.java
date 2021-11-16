package com.builders.mvp.controller;

import com.builders.mvp.domain.Client;
import com.builders.mvp.dto.request.ClientRequest;
import com.builders.mvp.dto.response.ClientResponse;
import com.builders.mvp.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/client", produces = APPLICATION_JSON_VALUE)
public class ClientController {

    private final ClientService service;

    @GetMapping("/user/{id}")
    public ResponseEntity<Client> findOne(@PathVariable String id) {

        Client client = service.findOne(id);

        return ResponseEntity.ok().body(client);
    }

    @GetMapping("{id}")
    public ResponseEntity<ClientResponse> find(@PathVariable String id) {

        ClientResponse client = service.find(id);

        return ResponseEntity.ok().body(client);
    }

    @PostMapping
    public ResponseEntity<Client> insert(@RequestBody ClientRequest request) {

        Client client = service.insert(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(client);
    }

    @PutMapping("{id}")
    public ResponseEntity<Client> update(@PathVariable String id,
        @RequestBody ClientRequest request) {

        Client client = service.update(id, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(client);
    }

    @GetMapping
    public ResponseEntity<List<ClientResponse>> findAll(
        @RequestParam(required = false, defaultValue = "0") int page,
        @RequestParam(required = false, defaultValue = "5") int size) {

        List<ClientResponse> client = service.findAll(page, size);

        return ResponseEntity.ok().body(client);
    }



}
