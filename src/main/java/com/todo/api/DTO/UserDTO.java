package com.todo.api.DTO;

import com.todo.api.entity.UserEntity;

public class UserDTO {
    private Long id;
    private String nome;
    private String email;
    private String password;

    private String provider;

    public UserDTO(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public UserDTO(String nome, String email, String password, String provider) {
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.provider = provider;
    }

    public UserDTO() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public UserEntity toEntity(){
        return new UserEntity(null, this.nome, this.email, this.password, this.provider, null);
    }
}
