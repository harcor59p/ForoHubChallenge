package com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.usuario;

import com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.perfil.Perfil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre ;
    private String email;
    private String password;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "perfil_id")
    private Perfil perfil ;

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
//    }

}