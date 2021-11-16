package com.builders.mvp.dto.response;

import com.builders.mvp.domain.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.Period;

@Data
@Builder
@AllArgsConstructor
public class ClientResponse {

    private String id;
    private String name;
    private String email;
    private int age;
    private String memberSince;

    public ClientResponse(Client client) {

        id = client.getId();
        name = client.getName();
        email = client.getEmail();
        age = Period.between(client.getBirth(), LocalDate.now()).getYears();
        memberSince = client.getCreatedAt().toString();

    }

}
