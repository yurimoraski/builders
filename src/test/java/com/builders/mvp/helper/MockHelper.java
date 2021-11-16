package com.builders.mvp.helper;

import com.builders.mvp.domain.Client;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MockHelper {

    public static Client getClientMock() {
        return Client.builder()
            .id("2319")
            .name("O Senhor")
            .email("senhor@builders.com")
            .document("33218600")
            .birth(LocalDate.of(2000, 01, 01))
            .createdAt(LocalDateTime.now())
            .build();
    }

}
