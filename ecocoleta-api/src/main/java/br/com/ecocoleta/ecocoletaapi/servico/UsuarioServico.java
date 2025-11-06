package br.com.ecocoleta.ecocoletaapi.servico;

import br.com.ecocoleta.ecocoletaapi.dtos.UsuarioRequisicaoDto;
import br.com.ecocoleta.ecocoletaapi.dtos.UsuarioRespostaDto;
import br.com.ecocoleta.ecocoletaapi.entidades.UsuarioEntidade;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UsuarioServico extends UserDetailsService {


    UsuarioRespostaDto criar(UsuarioRequisicaoDto dto);

    UsuarioEntidade buscarEntidadePorId(Long id);
}
