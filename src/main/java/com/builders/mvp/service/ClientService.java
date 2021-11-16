package com.builders.mvp.service;

import com.builders.mvp.domain.Client;
import com.builders.mvp.dto.request.ClientRequest;
import com.builders.mvp.dto.response.ClientResponse;
import com.builders.mvp.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository repo;

    public ClientResponse find(String id) {

        var client = repo.findById(id);

        return client.map(ClientResponse::new).orElse(null);
    }

    public Client findOne(String id) {
        return repo.findById(id).orElse(null);
    }

    public List<ClientResponse> findAll(int page, int size) {

        Pageable pages = PageRequest.of(page, size, Sort.by("createdAt").descending());

        var list = repo.findAll(pages);
        return list.stream().map(c -> new ClientResponse(c)).collect(Collectors.toList());
    }

    public Client insert(ClientRequest clientRequest) {

        Client newClient = newClient(clientRequest);
        return repo.insert(newClient);
    }

    public Client update(String id, ClientRequest changes) {

        var repoClient = repo.findById(id);


        if (repoClient.isPresent()) {
            var clientUpdate = updateClient(repoClient.get(), changes);
            clientUpdate.setId(id);
            return repo.save(clientUpdate);
        }

        return null;
    }

    private Client newClient(final ClientRequest clientRequest) {

        return Client.builder()
            .name(clientRequest.getName())
            .email(clientRequest.getEmail())
            .document(clientRequest.getDocument())
            .birth(clientRequest.getBirth())
            .createdAt(LocalDateTime.now())
            .build();
    }

    private Client updateClient(final Client client,final ClientRequest clientRequest) {

        if (clientRequest.getName() != null)
            client.setName(clientRequest.getName());

        if (clientRequest.getEmail() != null)
            client.setEmail(clientRequest.getEmail());

        if (clientRequest.getDocument() != null)
            client.setDocument(clientRequest.getDocument());

        if (clientRequest.getBirth() != null)
            client.setBirth(clientRequest.getBirth());

        return client;
    }

}
