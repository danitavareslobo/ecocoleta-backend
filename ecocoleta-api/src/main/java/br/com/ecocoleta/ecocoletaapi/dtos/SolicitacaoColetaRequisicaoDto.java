package br.com.ecocoleta.ecocoletaapi.dtos;

import br.com.ecocoleta.ecocoletaapi.enums.ItemColetaTipoMaterial;

import java.time.LocalDate;
import java.util.List;

public record SolicitacaoColetaRequisicaoDto(
        LocalDate dataAgenda,
        String observacoes,
        List<ItemColetaRequisicaoDto> itemColeta,
        //residencial ID para teste
        Long usuarioResidencialId,
        String feedback
){}
