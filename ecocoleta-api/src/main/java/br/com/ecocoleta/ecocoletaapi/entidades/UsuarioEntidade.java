package br.com.ecocoleta.ecocoletaapi.entidades;

import br.com.ecocoleta.ecocoletaapi.enums.UsuarioPerfil;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "usuario")
public class UsuarioEntidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150, nullable = false)
    private String nomeUsuario;

    @Column(length = 60, nullable = false)
    private String senha;

    //Observar mais tarde a questão de enum usuario/coletor
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UsuarioPerfil perfil = UsuarioPerfil.RESIDENCIAL;


    @Column(length = 8, nullable = false)
    private String cep;

    @Column(length = 255, nullable = false)
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
}
