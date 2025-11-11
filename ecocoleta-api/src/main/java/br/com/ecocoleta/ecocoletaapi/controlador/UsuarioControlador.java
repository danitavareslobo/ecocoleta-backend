package br.com.ecocoleta.ecocoletaapi.controlador;


import br.com.ecocoleta.ecocoletaapi.dtos.UsuarioRequisicaoDto;
import br.com.ecocoleta.ecocoletaapi.dtos.UsuarioRespostaDto;
import br.com.ecocoleta.ecocoletaapi.entidades.UsuarioEntidade;
import br.com.ecocoleta.ecocoletaapi.servico.UsuarioServico;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/usuarios")
public class UsuarioControlador {

    private final UsuarioServico servico;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioRespostaDto post(@RequestBody UsuarioRequisicaoDto dto){
        return servico.criar(dto);
    }

    @GetMapping("perfil")
    public UsuarioRespostaDto getPerfil(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UsuarioEntidade usuarioLogado = (UsuarioEntidade) authentication.getPrincipal();
        return servico.buscarPorId(usuarioLogado.getId());
    }

    @PutMapping("perfil")
    public UsuarioRespostaDto putPerfil(@RequestBody UsuarioRequisicaoDto dto){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UsuarioEntidade usuarioLogado = (UsuarioEntidade) authentication.getPrincipal();
        return servico.atualizar(usuarioLogado.getId(), dto);
    }

}
