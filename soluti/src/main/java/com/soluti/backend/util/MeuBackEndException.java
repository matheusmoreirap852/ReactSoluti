package com.soluti.backend.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
/**
 *	Classe	que	encapsula	as	excecoes do	backend
 */

public class MeuBackEndException extends ResponseStatusException {
    public MeuBackEndException(String mensagem)	{
        super(HttpStatus.INTERNAL_SERVER_ERROR,mensagem);
    }
}