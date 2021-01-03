package com.michelspirlandeli.bookstoremanager.author.exception;

import javax.persistence.EntityExistsException;

public class AuthorAlreadyExistsException extends EntityExistsException {

	private static final long serialVersionUID = 1L;

	public AuthorAlreadyExistsException(String name) {
        super(String.format("User witch name %s already is exists", name));
    }
}
