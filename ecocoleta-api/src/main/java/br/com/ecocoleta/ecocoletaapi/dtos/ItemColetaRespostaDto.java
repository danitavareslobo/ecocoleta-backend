package br.com.ecocoleta.ecocoletaapi.dtos;

import br.com.ecocoleta.ecocoletaapi.enums.ItemColetaQualidade;
import br.com.ecocoleta.ecocoletaapi.enums.ItemColetaTipoMaterial;

import java.math.BigDecimal;

public record ItemColetaRespostaDto(
    Long id,
    ItemColetaTipoMaterial tipoMaterial,
    BigDecimal quantidadeEstimada,
    BigDecimal quantidadeValida,
    ItemColetaQualidade qualidade
){}