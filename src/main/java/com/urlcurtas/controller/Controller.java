package com.urlcurtas.controller;

import com.urlcurtas.entity.Link;
import com.urlcurtas.entity.Usuario;
import com.urlcurtas.exception.Links.LinkNaoEncontrado;
import com.urlcurtas.exception.Usuario.UsuarioJaCadastrado;
import com.urlcurtas.exception.Usuario.UsuarioNaoEncontrado;
import com.urlcurtas.service.LinkService;
import com.urlcurtas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v2/url-curtas")
@CrossOrigin(origins = "*")
public class Controller {

    private UsuarioService usuarioService;
    private LinkService linkService;

    @Autowired
    public Controller(UsuarioService usuarioService, LinkService linkService){
        this.usuarioService = usuarioService;
        this.linkService= linkService;
    }

    @GetMapping("/listar")
    public List<Usuario> listar(){
        return  usuarioService.listar();
    }

    @PostMapping("/salvar")
    public ResponseEntity<Usuario> salvar(@Valid @RequestBody  Usuario usuario) throws UsuarioJaCadastrado {
       Usuario user = usuarioService.salvar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<Usuario> alterar(@Valid @PathVariable Long id, @RequestBody Usuario usuario) throws UsuarioNaoEncontrado {
        Usuario user = usuarioService.alterar(id, usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable Long id) throws UsuarioNaoEncontrado {
        usuarioService.deletar(id);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Usuario> buscar(@Valid @PathVariable Long id) throws UsuarioNaoEncontrado {
        Usuario user = usuarioService.buscar(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/usuario")
    public ResponseEntity<Usuario> buscarUsuario(@RequestBody Usuario usuario) {
        Usuario user = usuarioService.buscarUsuario(usuario.getEmail(), usuario.getSenha());
        return ResponseEntity.status(HttpStatus.FOUND).body(user);
    }

    //Link

    @PostMapping("/salvar/{id}")
    public ResponseEntity<Link> linkEncode(@PathVariable  Long id,@RequestBody Link link) throws UsuarioNaoEncontrado {
        var url = linkService.salvar(id, link);
        return ResponseEntity.ok(url);

    }

    @GetMapping("/decode/{linkCurto}")
    public ResponseEntity<Void>  linkDecode(@PathVariable String linkCurto){
        var url =linkService.Original(linkCurto);
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(url))
                .build();
    }





















//    @GetMapping("/links")
//    public List<Link> listarLinks(){
//        return linkService.listar();
//    }
//
//    @PostMapping("/links/{id}")
//    public ResponseEntity<Link> salvarLink(@PathVariable Long id ,@RequestBody Link link) throws UsuarioNaoEncontrado {
//        Link url = linkService.salvar(id, link);
//        return ResponseEntity.status(HttpStatus.CREATED).body(url);
//    }
//
//    @GetMapping("/{linkCurto}")
//    public ResponseEntity<Link> encontrarLink(@PathVariable String linkCurto){
//        Link url = linkService.linkCurtos(linkCurto);
//        if(url == null){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
//        url.getLink();
//        return  ResponseEntity.status(HttpStatus.OK).body(url);









   // }

//    @GetMapping("/links/{linkCurtos}")
//    public ResponseEntity<Link> link(@PathVariable String linkCurto){
//        Link url = linkService.findByShortURL(linkCurto);
//        return  ResponseEntity.ok(url);
//    }

//    @PostMapping("/")
//    public ResponseEntity<Link> insert(@RequestBody Link obj){
//        obj = linkService.insert(obj);
//        return  ResponseEntity.ok(obj);
//    }

    @GetMapping("/link/{id}")
    public ResponseEntity<Link> buscarLink(@PathVariable  Long id) throws  LinkNaoEncontrado {
        Link link =linkService.buscarLink(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(link);
    }

//    @GetMapping("/short/{id}")
//    public ResponseEntity<Link> encontrar(@PathVariable Long id) throws LinkNaoEncontrado {
//         Link url = linkService.encurtar(id);
//         return ResponseEntity.status(HttpStatus.OK).body(url);
//    }

    @DeleteMapping("/deletarLink/{id}")
    public void  deletarLink(@PathVariable Long id) throws LinkNaoEncontrado {
        linkService.deletar(id);
    }

}
