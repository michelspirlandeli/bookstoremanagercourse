package com.michelspirlandeli.bookstoremanager.author.service;

import com.michelspirlandeli.bookstoremanager.author.dto.AuthorDTO;
import com.michelspirlandeli.bookstoremanager.author.entity.Author;
import com.michelspirlandeli.bookstoremanager.author.exception.AuthorAlreadyExistsException;
import com.michelspirlandeli.bookstoremanager.author.mapper.AuthorMapper;
import com.michelspirlandeli.bookstoremanager.author.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    private final static AuthorMapper authorMapper = AuthorMapper.INSTANCE;

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    public AuthorDTO create(AuthorDTO authorDTO){
        verifyIfExists(authorDTO.getName());
        Author authorToCreate = authorMapper.toModel(authorDTO);
        Author createdAuthor = authorRepository.save(authorToCreate);
        return authorMapper.toDTO(createdAuthor);
    }

    private void verifyIfExists(String authorName) {
        authorRepository.findByName(authorName)
                .ifPresent(author -> {throw  new AuthorAlreadyExistsException(authorName);});
    }
}
