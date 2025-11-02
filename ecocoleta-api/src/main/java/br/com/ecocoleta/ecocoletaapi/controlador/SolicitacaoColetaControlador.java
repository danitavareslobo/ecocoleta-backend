package br.com.ecocoleta.ecocoletaapi.controlador;


import br.com.ecocoleta.ecocoletaapi.dtos.SolicitacaoColetaRequisicaoDto;
import br.com.ecocoleta.ecocoletaapi.dtos.UsuarioRequisicaoDto;
import br.com.ecocoleta.ecocoletaapi.dtos.SolicitacaoColetaRespostaDto;
import br.com.ecocoleta.ecocoletaapi.servico.SolicitacaoColetaServico;
import br.com.ecocoleta.ecocoletaapi.servico.UsuarioServico;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

    @GetMapping
    public List<SolicitacaoColetaRespostaDto> get(){
        return servico.buscarTodos();
    }

    @PutMapping("{id}")
    public SolicitacaoColetaRespostaDto put(@PathVariable Long id, @RequestBody SolicitacaoColetaRequisicaoDto dto){
        return servico.alterar(id, dto);
    }
}
