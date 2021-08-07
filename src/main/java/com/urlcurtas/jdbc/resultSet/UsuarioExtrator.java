package com.urlcurtas.jdbc.resultSet;


import com.urlcurtas.entity.Usuario;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioExtrator implements ResultSetExtractor<Usuario> {

    public Usuario extractData(ResultSet resultSet) throws SQLException, DataAccessException{
        Usuario user = new Usuario();

        user.setId(resultSet.getLong(1));
        user.setEmail(resultSet.getString(2));
        user.setSenha(resultSet.getString(3));

        return user;
    }
}
