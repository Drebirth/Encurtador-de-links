package com.urlcurtas.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @NotEmpty
    @Column(nullable = false, name = "email")
    private String email;

    @NotEmpty
    @Size(min = 4, max = 10)
    @Column(nullable = false ,name = "senha")
    private String senha;

    @JsonIgnoreProperties("usuario")
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Link> list = new ArrayList<>();


    public Usuario(Long id, String email, String senha, List<Link> list){
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.list = list;

    }
    public Usuario(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Link> getList() {
        return list;
    }

//    public void setList(List<Link> list) {
//        this.list = list;
//    }
}
