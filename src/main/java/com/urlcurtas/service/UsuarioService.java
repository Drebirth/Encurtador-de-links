package com.urlcurtas.service;

import com.urlcurtas.entity.Usuario;
import com.urlcurtas.exception.Usuario.UsuarioJaCadastrado;
import com.urlcurtas.exception.Usuario.UsuarioNaoEncontrado;
import com.urlcurtas.jdbc.rowMapper.UsuarioRowMapper;
import com.urlcurtas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private JdbcTemplate jdbcTemplate;


    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, JdbcTemplate jdbcTemplate){
        this.usuarioRepository=usuarioRepository;
        this.jdbcTemplate = jdbcTemplate;
    }


    public Usuario buscarUsuario(String email, String senha)  {
       List<Usuario> user = new ArrayList<>();
        String sql = "select * from usuario where email= '" + email + "' and senha = '"+ senha + "'";
        user = jdbcTemplate.query(sql, new UsuarioRowMapper());
        return user.get(0);
    }

    public List<Usuario> listar(){
        List<Usuario> user = new ArrayList<>();
        String sql = "select * from usuario";
        user = jdbcTemplate.query(sql, new UsuarioRowMapper());
        return user;
    }

    public Usuario salvar(Usuario usuario) throws UsuarioJaCadastrado {
         verificarEmail(usuario);
         return usuarioRepository.save(usuario);
    }

    public Usuario alterar(Long id, Usuario usuario) throws UsuarioNaoEncontrado {
       Usuario user = buscarId(id);
        user.setSenha(usuario.getSenha());
        return usuarioRepository.save(user);
    }

    public void deletar(Long id) throws UsuarioNaoEncontrado {
        Usuario user = buscarId(id);
        usuarioRepository.delete(user);
    }

    public Usuario buscar(Long id) throws UsuarioNaoEncontrado {
        var user = buscarId(id);
        return user;
    }

    //métodos
    private Usuario buscarId(Long id)throws  UsuarioNaoEncontrado{
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontrado(id));
    }

    private void verificarEmail(Usuario usuario) throws UsuarioJaCadastrado {
      Optional<Usuario> user =usuarioRepository.findByEmail(usuario.getEmail());
        if (user.isPresent()){
            throw new UsuarioJaCadastrado(usuario.getEmail(), usuario.getSenha());
        }
    }

}
