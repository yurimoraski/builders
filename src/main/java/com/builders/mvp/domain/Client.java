package com.builders.mvp.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@Document
public class Client {

    @Id
    private String id;
    private String name;
    @Indexed
    private String email;
    private String document;
    private LocalDate birth;
    private LocalDateTime createdAt;

}
