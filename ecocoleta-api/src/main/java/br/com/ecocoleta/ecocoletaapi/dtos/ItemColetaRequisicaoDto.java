package br.com.ecocoleta.ecocoletaapi.dtos;

import br.com.ecocoleta.ecocoletaapi.enums.ItemColetaQualidade;
import br.com.ecocoleta.ecocoletaapi.enums.ItemColetaTipoMaterial;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record ItemColetaRequisicaoDto(
        ItemColetaTipoMaterial tipoMaterial,
        BigDecimal quantidadeEstimada,
        BigDecimal quantidadeValida,
        ItemColetaQualidade qualidade
){}
