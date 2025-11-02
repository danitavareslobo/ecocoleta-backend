package br.com.ecocoleta.ecocoletaapi.servico;

import br.com.ecocoleta.ecocoletaapi.dtos.SolicitacaoColetaRequisicaoDto;
import br.com.ecocoleta.ecocoletaapi.dtos.SolicitacaoColetaRespostaDto;

import java.util.List;

public interface SolicitacaoColetaServico {

    SolicitacaoColetaRespostaDto criar(SolicitacaoColetaRequisicaoDto dto);

    List<SolicitacaoColetaRespostaDto> buscarTodos();

    SolicitacaoColetaRespostaDto alterar(Long id, SolicitacaoColetaRequisicaoDto dto);

    List<SolicitacaoColetaRespostaDto> listSolicitacoesAguardando();

    SolicitacaoColetaRespostaDto coletar(Long id);

    SolicitacaoColetaRespostaDto cancelar(Long id);

    SolicitacaoColetaRespostaDto finalizar(Long id);

    SolicitacaoColetaRespostaDto feedback(Long id, SolicitacaoColetaRequisicaoDto dto);

}
