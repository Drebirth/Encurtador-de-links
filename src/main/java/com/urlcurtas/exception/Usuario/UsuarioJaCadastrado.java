package com.urlcurtas.exception.Usuario;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FOUND)
public class UsuarioJaCadastrado  extends  Exception{
    public UsuarioJaCadastrado(String email, String senha){
        super("Usuario já cadastrado!" + email);
    }
}
