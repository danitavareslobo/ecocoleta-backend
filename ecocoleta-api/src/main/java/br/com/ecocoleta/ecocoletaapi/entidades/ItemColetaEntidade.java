package br.com.ecocoleta.ecocoletaapi.entidades;

import br.com.ecocoleta.ecocoletaapi.enums.ItemColetaQualidade;
import br.com.ecocoleta.ecocoletaapi.enums.ItemColetaTipoMaterial;
import br.com.ecocoleta.ecocoletaapi.enums.SolicitacaoColetaStatus;
import br.com.ecocoleta.ecocoletaapi.enums.UsuarioPerfil;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "usuario")
public class ItemColetaEntidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private ItemColetaTipoMaterial tipoMaterial;

    @Column(nullable = false)
    private BigDecimal quantidadeEstimada;

    @Column(nullable = false)
    private BigDecimal quantidadeValida;

    @Column(name = "estado")
    private ItemColetaQualidade qualidade;


    //Convesar com equipe para garantia se sera um item por solicitação ou varios itens
    @ManyToOne
    @JoinColumn(name = "solicitacao_coleta_id")
    private SolicitacaoColetaEntidade solicitacaoColeta;










}
