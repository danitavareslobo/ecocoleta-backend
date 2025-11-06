package br.com.ecocoleta.ecocoletaapi.dtos;


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
