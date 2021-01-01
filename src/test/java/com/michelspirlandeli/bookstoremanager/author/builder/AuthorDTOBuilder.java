package com.michelspirlandeli.bookstoremanager.author.builder;


import com.michelspirlandeli.bookstoremanager.author.dto.AuthorDTO;
import lombok.Builder;

@Builder
public class AuthorDTOBuilder {

    @Builder.Default
    private final Long id = 1L;
    @Builder.Default
    private final String name = "Michel Spirlandeli";
    @Builder.Default
    private final int age = 34;

    public AuthorDTO BuilderAuthorDTO(){
        return new AuthorDTO(id, name, age);
    }
}
