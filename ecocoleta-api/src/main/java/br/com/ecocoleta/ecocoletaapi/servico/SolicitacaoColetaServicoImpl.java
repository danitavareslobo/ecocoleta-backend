package br.com.ecocoleta.ecocoletaapi.servico;


import br.com.ecocoleta.ecocoletaapi.dtos.SolicitacaoColetaRequisicaoDto;
import br.com.ecocoleta.ecocoletaapi.dtos.SolicitacaoColetaRespostaDto;
import br.com.ecocoleta.ecocoletaapi.entidades.ItemColetaEntidade;
import br.com.ecocoleta.ecocoletaapi.entidades.SolicitacaoColetaEntidade;
import br.com.ecocoleta.ecocoletaapi.entidades.UsuarioEntidade;
import br.com.ecocoleta.ecocoletaapi.enums.SolicitacaoColetaStatus;
import br.com.ecocoleta.ecocoletaapi.mapeador.SolicitacaoColetaMapeador;
import br.com.ecocoleta.ecocoletaapi.repositorio.SolicitacaoColetaRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SolicitacaoColetaServicoImpl implements SolicitacaoColetaServico {

    private final SolicitacaoColetaRepositorio repositorio;
    private final UsuarioServico servico;

    @Override
    public SolicitacaoColetaRespostaDto criar(SolicitacaoColetaRequisicaoDto dto) {

        SolicitacaoColetaEntidade entidade = new SolicitacaoColetaEntidade();
        SolicitacaoColetaMapeador.paraEntidade(entidade, dto);
        UsuarioEntidade usuarioResidencialEntidade = servico.buscarEntidadePorId(dto.usuarioResidencialId());
        entidade.setUsuarioResidencial(usuarioResidencialEntidade);
        List<ItemColetaEntidade> itens = SolicitacaoColetaMapeador.listParaEntidade(dto.itemColeta(), entidade);
        entidade.setItemColeta(itens);
        repositorio.save(entidade);
        return SolicitacaoColetaMapeador.paraDto(entidade);

    }

    @Override
    public List<SolicitacaoColetaRespostaDto> buscarTodos() {
        List<SolicitacaoColetaEntidade> listaEntidades = repositorio.findAll();
        List<SolicitacaoColetaRespostaDto> listaRespostas = new ArrayList<>();

        for(SolicitacaoColetaEntidade entidade : listaEntidades){
            SolicitacaoColetaRespostaDto resposta = SolicitacaoColetaMapeador.paraDto(entidade);
            listaRespostas.add(resposta);
        }

        return listaRespostas;
    }

    @Override
    public SolicitacaoColetaRespostaDto alterar(Long id, SolicitacaoColetaRequisicaoDto dto) {

        SolicitacaoColetaEntidade entidade = buscarEntidadePorId(id);
        SolicitacaoColetaMapeador.paraEntidade(entidade, dto);
        entidade.getItemColeta().clear();
        List<ItemColetaEntidade> novosItens = SolicitacaoColetaMapeador.listParaEntidade(dto.itemColeta(), entidade);
        entidade.getItemColeta().addAll(novosItens);

        repositorio.save(entidade);

        return SolicitacaoColetaMapeador.paraDto(entidade);
    }

    @Override
    public List<SolicitacaoColetaRespostaDto> listSolicitacoesAguardando() {
        List<SolicitacaoColetaEntidade> entidades = repositorio.findAllByStatus(SolicitacaoColetaStatus.AGUARDANDO);

        return entidades.stream()
                .map(SolicitacaoColetaMapeador::paraDto)
                .collect(Collectors.toList());
    }

    @Override
    public SolicitacaoColetaRespostaDto coletar(Long id) {
        SolicitacaoColetaEntidade entidade = buscarEntidadePorId(id);
        entidade.setStatus(SolicitacaoColetaStatus.COLETADA);
        repositorio.save(entidade);
        return SolicitacaoColetaMapeador.paraDto(entidade);
    }

    @Override
    public SolicitacaoColetaRespostaDto cancelar(Long id){
        SolicitacaoColetaEntidade entidade = buscarEntidadePorId(id);
        entidade.setStatus(SolicitacaoColetaStatus.CANCELADA);
        repositorio.save(entidade);
        return SolicitacaoColetaMapeador.paraDto(entidade);
    }

    @Override
    public SolicitacaoColetaRespostaDto finalizar(Long id){
        SolicitacaoColetaEntidade entidade = buscarEntidadePorId(id);
        entidade.setStatus(SolicitacaoColetaStatus.FINALIZADA);
        repositorio.save(entidade);
        return SolicitacaoColetaMapeador.paraDto(entidade);
    }

    @Override
    public SolicitacaoColetaRespostaDto feedback(Long id, SolicitacaoColetaRequisicaoDto dto) {
        SolicitacaoColetaEntidade entidade = buscarEntidadePorId(id);
        entidade.setFeedback(dto.feedback());
        repositorio.save(entidade);
        return SolicitacaoColetaMapeador.paraDto(entidade);
    }

    private SolicitacaoColetaEntidade buscarEntidadePorId(Long id){
        return repositorio.findById(id).orElseThrow();
    }




}
