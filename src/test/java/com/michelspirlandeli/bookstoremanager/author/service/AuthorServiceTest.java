package com.michelspirlandeli.bookstoremanager.author.service;

import com.michelspirlandeli.bookstoremanager.author.builder.AuthorDTOBuilder;
import com.michelspirlandeli.bookstoremanager.author.dto.AuthorDTO;
import com.michelspirlandeli.bookstoremanager.author.entity.Author;
import com.michelspirlandeli.bookstoremanager.author.exception.AuthorAlreadyExistsException;
import com.michelspirlandeli.bookstoremanager.author.mapper.AuthorMapper;
import com.michelspirlandeli.bookstoremanager.author.repository.AuthorRepository;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {

    private final AuthorMapper authorMapper = AuthorMapper.INSTANCE;

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorService authorService;

    private AuthorDTOBuilder authorDTOBuilder;

    @BeforeEach
    void setUp(){
        authorDTOBuilder = AuthorDTOBuilder.builder().build();
    }

    @Test
    void whenNewAuthorIsInformendThenItShouldBeCrated() {
        //given
        AuthorDTO expectedAuthorToCreatedDTO = authorDTOBuilder.BuilderAuthorDTO();
        Author expectedCreatedAuthor = authorMapper.toModel(expectedAuthorToCreatedDTO);

        //when
        Mockito.when(authorRepository.save(expectedCreatedAuthor)).thenReturn(expectedCreatedAuthor);
        Mockito.when(authorRepository.findByName(expectedAuthorToCreatedDTO.getName())).thenReturn(Optional.empty());
        AuthorDTO createdAuthorDTO = authorService.create(expectedAuthorToCreatedDTO);

        //then
        assertThat(createdAuthorDTO, Is.is(IsEqual.equalTo(expectedAuthorToCreatedDTO)));
    }

    @Test
    void whenExistingAuthorIsInformendThenAnExceptionShouldBeThown() {

        AuthorDTO expectedAuthorToCreatedDTO = authorDTOBuilder.BuilderAuthorDTO();
        Author expectedCreatedAuthor = authorMapper.toModel(expectedAuthorToCreatedDTO);


        Mockito.when(authorRepository.findByName(expectedAuthorToCreatedDTO.getName())).thenReturn(Optional.of(expectedCreatedAuthor));

        assertThrows(AuthorAlreadyExistsException.class, () -> authorService.create(expectedAuthorToCreatedDTO));


    }
}
