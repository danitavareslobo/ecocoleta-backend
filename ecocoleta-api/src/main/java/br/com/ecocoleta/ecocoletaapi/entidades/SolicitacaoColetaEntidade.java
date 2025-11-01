package br.com.ecocoleta.ecocoletaapi.entidades;

import br.com.ecocoleta.ecocoletaapi.enums.SolicitacaoColetaStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.OffsetDateTime;

@Data
@Entity
@Table(name = "usuario")
public class SolicitacaoColetaEntidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private SolicitacaoColetaStatus status = SolicitacaoColetaStatus.AGUARDANDO;

    @Column(nullable = false)
    private OffsetDateTime dataSolicitacao;

    @Column(nullable = false)
    private LocalDate dataAgenda;

    @Column(length = 100, nullable = false)
    private String observacoes;

    @Column(length = 100)
    private String feedback;


    //Pesquisar sobre a questão de usuario residencial e coletor
    @ManyToOne
    @JoinColumn(name = "usuario_residencial_id")
    private UsuarioEntidade usuarioResidencial;

    @ManyToOne
    @JoinColumn(name = "usuario_coletor_id")
    private UsuarioEntidade usuarioColetor;

}
