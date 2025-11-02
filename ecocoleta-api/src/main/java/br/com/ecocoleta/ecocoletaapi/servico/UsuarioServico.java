package br.com.ecocoleta.ecocoletaapi.servico;

import br.com.ecocoleta.ecocoletaapi.dtos.UsuarioRequisicaoDto;
import br.com.ecocoleta.ecocoletaapi.dtos.UsuarioRespostaDto;
import br.com.ecocoleta.ecocoletaapi.entidades.UsuarioEntidade;

import java.util.List;

public interface UsuarioServico {


    //GET PARA TESTES
    List<UsuarioRespostaDto> buscarTodos();

    UsuarioRespostaDto criar(UsuarioRequisicaoDto dto);

    UsuarioEntidade buscarEntidadePorId(Long id);
}
