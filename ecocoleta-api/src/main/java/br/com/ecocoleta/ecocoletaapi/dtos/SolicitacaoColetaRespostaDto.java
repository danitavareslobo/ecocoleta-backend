package br.com.ecocoleta.ecocoletaapi.dtos;

import br.com.ecocoleta.ecocoletaapi.enums.SolicitacaoColetaStatus;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;

public record SolicitacaoColetaRespostaDto(
        Long id,
        SolicitacaoColetaStatus status,
        OffsetDateTime dataSolicitacao,
        LocalDate dataAgenda,
        String observacoes,
        String feedback,
        UsuarioRespostaDto usuarioResidencial,
        List<ItemColetaRespostaDto> itemColeta

){}