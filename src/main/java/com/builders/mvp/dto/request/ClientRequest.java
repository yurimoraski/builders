package com.builders.mvp.dto.request;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ClientRequest {

    private String name;
    private String email;
    private String document;
    private LocalDate birth;

}
