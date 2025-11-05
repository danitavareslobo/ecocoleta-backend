package br.com.ecocoleta.ecocoletaapi.entidades;

import br.com.ecocoleta.ecocoletaapi.enums.UsuarioPerfil;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "usuario")
public class UsuarioEntidade implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150, nullable = false)
    private String nomeUsuario;

    @Column(length = 100, nullable = false)
    private String senha;

    //Observar mais tarde a questão de enum usuario/coletor
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UsuarioPerfil perfil = UsuarioPerfil.RESIDENCIAL;


    @Column(length = 8, nullable = false)
    private String cep;

    @Column( nullable = false)
    private String logradouro;

    @Column(length = 2, nullable = false)
    private String estado;

    @Column(length = 100, nullable = false)
    private String cidade;

    @Column(length = 100, nullable = false)
    private String bairro;

    @Column(length = 10, nullable = false)
    private String numero;

    @Column(length = 100, nullable = false)
    private String complemento;

    @Column
    private BigDecimal latitude;

    @Column
    private BigDecimal longitude;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of((GrantedAuthority) ()-> perfil.name());
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return nomeUsuario;
    }
}
