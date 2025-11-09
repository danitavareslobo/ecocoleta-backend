package br.com.ecocoleta.ecocoletaapi.controlador;


import br.com.ecocoleta.ecocoletaapi.dtos.SolicitacaoColetaRequisicaoDto;
import br.com.ecocoleta.ecocoletaapi.dtos.SolicitacaoColetaRespostaDto;
import br.com.ecocoleta.ecocoletaapi.entidades.UsuarioEntidade;
import br.com.ecocoleta.ecocoletaapi.servico.SolicitacaoColetaServico;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/coletas")
public class SolicitacaoColetaControlador {

    private final SolicitacaoColetaServico servico;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SolicitacaoColetaRespostaDto post(@RequestBody SolicitacaoColetaRequisicaoDto dto){
        return servico.criar(dto);
    }

    @GetMapping("minhas")
    public List<SolicitacaoColetaRespostaDto> getResidencial(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UsuarioEntidade usuarioLogado = (UsuarioEntidade) authentication.getPrincipal();
        return servico.buscarPorUsuarioResidencial(usuarioLogado.getId());
    }

    @PutMapping("{id}")
    public SolicitacaoColetaRespostaDto put(@PathVariable Long id, @RequestBody SolicitacaoColetaRequisicaoDto dto){
        return servico.alterar(id, dto);
    }

    //Endpoint para coletores - retorna TODAS as solicitações
    @GetMapping
    public List<SolicitacaoColetaRespostaDto> getColetor(){
        return servico.buscarTodos();
    }

    @PatchMapping("{id}/coletar")
    public SolicitacaoColetaRespostaDto coletar(@PathVariable Long id){
        return servico.coletar(id);
    }

    @PatchMapping("{id}/cancelar")
    public SolicitacaoColetaRespostaDto cancelar(@PathVariable Long id){
        return servico.cancelar(id);
    }

    @PatchMapping("{id}/finalizar")
    public SolicitacaoColetaRespostaDto finalizar(@PathVariable Long id){
        return servico.finalizar(id);
    }

    @PatchMapping("{id}/feedback")
    public SolicitacaoColetaRespostaDto feedback(@PathVariable Long id, @RequestBody SolicitacaoColetaRequisicaoDto dto){
        return servico.feedback(id, dto);
    }

}
