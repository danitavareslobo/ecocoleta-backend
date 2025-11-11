package br.com.ecocoleta.ecocoletaapi.mapeador;

import br.com.ecocoleta.ecocoletaapi.dtos.*;
import br.com.ecocoleta.ecocoletaapi.entidades.ItemColetaEntidade;
import br.com.ecocoleta.ecocoletaapi.entidades.SolicitacaoColetaEntidade;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class SolicitacaoColetaMapeador {

    private SolicitacaoColetaMapeador(){};


    public static SolicitacaoColetaRespostaDto paraDto(SolicitacaoColetaEntidade entidade){
        return new SolicitacaoColetaRespostaDto(
                entidade.getId(),
                entidade.getStatus(),
                entidade.getDataSolicitacao(),
                entidade.getDataAgenda(),
                entidade.getObservacoes(),
                entidade.getFeedback(),
                UsuarioMapeador.paraDto(entidade.getUsuarioResidencial()),
                listParaDto(entidade.getItemColeta())

        );
    }
    public static List<ItemColetaRespostaDto> listParaDto(List<ItemColetaEntidade> entidades){
        return entidades.stream().map(SolicitacaoColetaMapeador::paraDto).toList();
    }

    public static ItemColetaRespostaDto paraDto(ItemColetaEntidade entidade){
        return new ItemColetaRespostaDto(
                entidade.getId(),
                entidade.getTipoMaterial(),
                entidade.getQuantidadeEstimada(),
                entidade.getQuantidadeValida(),
                entidade.getQualidade()
        );
    }

    public static SolicitacaoColetaEntidade paraEntidade(SolicitacaoColetaEntidade entidade, SolicitacaoColetaRequisicaoDto dto){
        entidade.setDataAgenda(dto.dataAgenda());
        entidade.setObservacoes(dto.observacoes());
        entidade.setDataSolicitacao(OffsetDateTime.now());
        return entidade;

    }

    public static List<ItemColetaEntidade>  listParaEntidade(
                List<ItemColetaRequisicaoDto> listDto,
                SolicitacaoColetaEntidade entidade
    ){
        return listDto.stream().map(
                dto -> paraItemEntidade(entidade, dto)
        ).collect(Collectors.toList());
    }

    public static ItemColetaEntidade paraItemEntidade(
            SolicitacaoColetaEntidade solicitacaoEntidade,
            ItemColetaRequisicaoDto dto
    ){
        ItemColetaEntidade itemEntidade = new ItemColetaEntidade();

        itemEntidade.setTipoMaterial(dto.tipoMaterial());
        itemEntidade.setQuantidadeEstimada(dto.quantidadeEstimada());
        itemEntidade.setQualidade(dto.qualidade());

        itemEntidade.setSolicitacaoColeta(solicitacaoEntidade);

        return itemEntidade;
    }

}
