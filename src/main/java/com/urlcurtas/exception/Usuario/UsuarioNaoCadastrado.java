package com.urlcurtas.exception.Usuario;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsuarioNaoCadastrado extends  Exception{

    public UsuarioNaoCadastrado(String senha){
        super("Usuario nao encontrado");
    }
}
