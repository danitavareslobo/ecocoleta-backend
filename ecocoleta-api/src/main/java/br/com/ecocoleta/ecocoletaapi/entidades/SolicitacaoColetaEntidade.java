package br.com.ecocoleta.ecocoletaapi.entidades;

import br.com.ecocoleta.ecocoletaapi.enums.SolicitacaoColetaStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "solicitacao_coleta")
public class SolicitacaoColetaEntidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
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


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitacaoColeta", orphanRemoval = true)
    private List<ItemColetaEntidade> itemColeta;

    //Pesquisar sobre a questão de usuario residencial e coletor
    @ManyToOne
    @JoinColumn(name = "usuario_residencial_id", nullable = false)
    private UsuarioEntidade usuarioResidencial;

    @ManyToOne
    @JoinColumn(name = "usuario_coletor_id")
    private UsuarioEntidade usuarioColetor;

}
