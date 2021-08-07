package com.urlcurtas.service;

import com.urlcurtas.entity.Link;
import com.urlcurtas.exception.Links.LinkNaoEncontrado;
import com.urlcurtas.exception.Usuario.UsuarioNaoEncontrado;
import com.urlcurtas.repository.LinkRepository;
import com.urlcurtas.service.urlService.BaseConversao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class LinkService {
    private LinkRepository linkRepository;
    private UsuarioService usuarioService;
    private BaseConversao bs;


    @Autowired
    public LinkService(LinkRepository linkRepository, UsuarioService usuarioService, BaseConversao bs ){
        this.linkRepository = linkRepository;
        this.usuarioService = usuarioService;
        this.bs = bs;


    }

    public Link salvar(Long id, Link link) throws UsuarioNaoEncontrado {
        var user = usuarioService.buscar(id);
        user.setId(user.getId());
        link.setLocalDateTime(LocalDateTime.now());
        link.setUsuario(user);
        link = linkRepository.save(link);
        link.setLinkCurto(bs.encode(link.getId()));
        return linkRepository.save(link);
    }

    public String Original(String linkCurto){
        var id = bs.decode(linkCurto);
        var entity = linkRepository.findById(id);
        return entity.getLink();
    }

    public void deletar(Long id) throws LinkNaoEncontrado {
        Link link = buscar(id);
        linkRepository.delete(link);
    }

    public Link buscarLink(Long id) throws LinkNaoEncontrado {
        Link url = buscar(id);
        return url;
    }



    //Métodos
    private Link buscar(Long id) throws LinkNaoEncontrado {
        return linkRepository.findById(id)
                .orElseThrow( () -> new LinkNaoEncontrado(id) );
    }


}
