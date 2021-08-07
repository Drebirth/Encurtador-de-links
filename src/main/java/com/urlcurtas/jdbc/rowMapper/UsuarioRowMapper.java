package com.urlcurtas.jdbc.rowMapper;

import com.urlcurtas.entity.Usuario;
import com.urlcurtas.jdbc.resultSet.UsuarioExtrator;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioRowMapper implements RowMapper<Usuario> {

    @Override
    public Usuario mapRow(ResultSet resultSet, int line)throws SQLException{
        UsuarioExtrator usuarioExtrator = new UsuarioExtrator();
        return usuarioExtrator.extractData(resultSet);
    }


}
