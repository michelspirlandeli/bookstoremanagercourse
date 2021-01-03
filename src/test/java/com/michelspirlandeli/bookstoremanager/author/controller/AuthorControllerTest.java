package com.michelspirlandeli.bookstoremanager.author.controller;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.net.URI;
import java.util.Collections;

import com.michelspirlandeli.bookstoremanager.author.builder.AuthorDTOBuilder;
import com.michelspirlandeli.bookstoremanager.author.dto.AuthorDTO;
import com.michelspirlandeli.bookstoremanager.author.service.AuthorService;
import com.michelspirlandeli.bookstoremanager.utils.JsonConvertionUtils;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class AuthorControllerTest {

    private static final String AUTHOR_API_URL_PATH = "/api/v1/authors";

	@Mock
    private AuthorService authorService;

    @InjectMocks
    private AuthorController authorController;

    private MockMvc mockMvc;

    private AuthorDTOBuilder authorDTOBuilder;

    @BeforeEach
    void setUp() {
        authorDTOBuilder = AuthorDTOBuilder.builder().build();
        mockMvc = MockMvcBuilders.standaloneSetup(authorController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers((s, locale) -> new MappingJackson2JsonView())
                .build();
    }
    
    @Test
    void whenPostIsCalledThenStatusCreatedShouldBeReturned() throws Exception {
    	AuthorDTO expextedCreatedAuthorDTO = authorDTOBuilder.BuilderAuthorDTO();
    	
    	Mockito.when(authorService.create(expextedCreatedAuthorDTO))
    		.thenReturn(expextedCreatedAuthorDTO);
    	
    	mockMvc.perform(MockMvcRequestBuilders.post(AUTHOR_API_URL_PATH)
    			.contentType(MediaType.APPLICATION_JSON)
    			.content(JsonConvertionUtils.asJsonString(expextedCreatedAuthorDTO)))
    			.andExpect(MockMvcResultMatchers.status().isCreated())
    			.andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(expextedCreatedAuthorDTO.getId().intValue())))
    			.andExpect(MockMvcResultMatchers.jsonPath("$.nome", Is.is(expextedCreatedAuthorDTO.getName())))
    			.andExpect(MockMvcResultMatchers.jsonPath("$.age", Is.is(expextedCreatedAuthorDTO.getAge())));
    }

    @Test
    void whenPOSTIsCalledWithoutRequiredFieldThenBadRequestShouldBeInformed() throws Exception {
        AuthorDTO expectedCreatedAuthorDTO = AuthorDTOBuilder.builder().build().BuilderAuthorDTO();
        expectedCreatedAuthorDTO.setName(null);

        mockMvc.perform(post(AUTHOR_API_URL_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonConvertionUtils.asJsonString(expectedCreatedAuthorDTO)))
                .andExpect(status().isBadRequest());
    }
    
    
}
