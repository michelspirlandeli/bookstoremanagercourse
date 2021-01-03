package com.michelspirlandeli.bookstoremanager.author.controller;

import com.michelspirlandeli.bookstoremanager.author.dto.AuthorDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("Authors management")
public interface AuthorControllerDocs {
	
	@ApiOperation(value = "Author created operation")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Success author created"),
			@ApiResponse(code = 400, message = "Missing required filds")
	})
	AuthorDTO create(AuthorDTO authorDTO);
}
