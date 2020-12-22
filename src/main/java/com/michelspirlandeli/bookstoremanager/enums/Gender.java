package com.michelspirlandeli.bookstoremanager.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public enum Gender {

    MALE("Male"),
    FEMALE("Female");

    private String description;

    Gender(String description) {
        this.description = description;
    }
}
