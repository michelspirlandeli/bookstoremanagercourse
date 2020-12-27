package com.michelspirlandeli.bookstoremanager.author.service;

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
}
