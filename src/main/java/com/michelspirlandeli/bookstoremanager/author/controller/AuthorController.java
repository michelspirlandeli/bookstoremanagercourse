package com.michelspirlandeli.bookstoremanager.author.controller;

import com.michelspirlandeli.bookstoremanager.author.dto.AuthorDTO;
import com.michelspirlandeli.bookstoremanager.author.service.AuthorService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController implements AuthorControllerDocs {

    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
	public AuthorDTO create(@RequestBody @Valid AuthorDTO authorDTO) {
		return authorService.create(authorDTO);
	}
    
    
}
