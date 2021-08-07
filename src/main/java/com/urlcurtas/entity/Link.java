package com.urlcurtas.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String link;

    private String linkCurto;

    @Column(nullable = false)
    private LocalDateTime localDateTime;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Link(Long id, String link, String linkCurto){
        this.id = id;
        this.link = link;
        this.linkCurto = linkCurto;
    }
     public Link(){

     }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLinkCurto() {
        return linkCurto;
    }

    public void setLinkCurto(String linkCurto) {
        this.linkCurto = linkCurto;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


}
