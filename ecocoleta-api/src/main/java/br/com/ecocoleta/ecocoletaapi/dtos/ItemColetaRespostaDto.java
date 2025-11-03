package br.com.ecocoleta.ecocoletaapi.dtos;

import br.com.ecocoleta.ecocoletaapi.enums.ItemColetaQualidade;
import br.com.ecocoleta.ecocoletaapi.enums.ItemColetaTipoMaterial;
import br.com.ecocoleta.ecocoletaapi.enums.SolicitacaoColetaStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;

public record ItemColetaRespostaDto(
    Long id,
    ItemColetaTipoMaterial tipoMaterial,
    BigDecimal quantidadeEstimada,
    BigDecimal quantidadeValida,
    ItemColetaQualidade qualidade
){}