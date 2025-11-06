package br.com.ecocoleta.ecocoletaapi.servico;

import br.com.ecocoleta.ecocoletaapi.dtos.UsuarioRequisicaoDto;
import br.com.ecocoleta.ecocoletaapi.dtos.UsuarioRespostaDto;
import br.com.ecocoleta.ecocoletaapi.entidades.UsuarioEntidade;
import br.com.ecocoleta.ecocoletaapi.mapeador.UsuarioMapeador;
import br.com.ecocoleta.ecocoletaapi.repositorio.UsuarioRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UsuarioServicoImpl implements UsuarioServico{

    private final UsuarioRepositorio repositorio;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UsuarioRespostaDto criar(UsuarioRequisicaoDto dto) {
        UsuarioEntidade entidade = salvarEntidade(new UsuarioEntidade(), dto);

        return UsuarioMapeador.paraDto(entidade);
    }

    @Override
    public UsuarioEntidade buscarEntidadePorId(Long id) {
        return repositorio.findById(id).orElseThrow();
    }

    public UsuarioEntidade salvarEntidade(UsuarioEntidade entidade, UsuarioRequisicaoDto dto){
        UsuarioMapeador.paraEntidade(entidade, dto);
        entidade.setSenha(passwordEncoder.encode(dto.senha()));
        return repositorio.save(entidade);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repositorio.findByNomeUsuario(username).orElseThrow();
    }
}
