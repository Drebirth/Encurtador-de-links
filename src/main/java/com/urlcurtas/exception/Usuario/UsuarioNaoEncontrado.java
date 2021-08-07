package com.urlcurtas.exception.Usuario;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsuarioNaoEncontrado extends  Exception {
    public UsuarioNaoEncontrado(Long id){
        super("Usuario nao encontrado!");
    }
}
