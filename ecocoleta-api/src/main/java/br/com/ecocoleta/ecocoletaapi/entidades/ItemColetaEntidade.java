package br.com.ecocoleta.ecocoletaapi.entidades;

import br.com.ecocoleta.ecocoletaapi.enums.ItemColetaQualidade;
import br.com.ecocoleta.ecocoletaapi.enums.ItemColetaTipoMaterial;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "item_coleta")
public class ItemColetaEntidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column
    private ItemColetaTipoMaterial tipoMaterial;

    @Column(nullable = false)
    private BigDecimal quantidadeEstimada;

    @Column(name = "quantidade_validada")
    private BigDecimal quantidadeValida;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private ItemColetaQualidade qualidade;

    @ManyToOne
    @JoinColumn(name = "solicitacao_coleta_id")
    private SolicitacaoColetaEntidade solicitacaoColeta;










}
