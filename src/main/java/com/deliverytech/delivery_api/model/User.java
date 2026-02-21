package com.deliverytech.delivery_api.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.deliverytech.delivery_api.enums.Role;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@Table(name = "usuarios")
public class User implements UserDetails{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    private Boolean ativo = true;

    private Long clienteId;

    private Long restauranteId;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return List.of(new SimpleGrantedAuthority("ROLE_" + role));
    }

    

    public User() {
    }



    public User(String nome, String email, String senha, Role role, Boolean ativo) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.role = role;
        this.ativo = ativo;
    }



    @Override
    public String getUsername(){return email;}

    @Override
    public String getPassword(){return senha;}

    @Override
    public boolean isAccountNonLocked() {
        return ativo;
    }

    @Override
    public boolean isEnabled() {
        return ativo;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


}