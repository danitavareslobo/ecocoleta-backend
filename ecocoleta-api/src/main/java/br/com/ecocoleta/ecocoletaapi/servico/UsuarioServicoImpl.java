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

    @Override
    public UsuarioRespostaDto buscarPorId(Long id) {
        UsuarioEntidade entidade = buscarEntidadePorId(id);
        return UsuarioMapeador.paraDto(entidade);
    }

    @Override
    public UsuarioRespostaDto atualizar(Long id, UsuarioRequisicaoDto dto) {
        UsuarioEntidade entidade = buscarEntidadePorId(id);

        entidade.setCep(dto.cep());
        entidade.setLogradouro(dto.logradouro());
        entidade.setEstado(dto.estado());
        entidade.setCidade(dto.cidade());
        entidade.setBairro(dto.bairro());
        entidade.setNumero(dto.numero());
        entidade.setComplemento(dto.complemento());

        if (dto.latitude() != null) {
            entidade.setLatitude(java.math.BigDecimal.valueOf(dto.latitude()));
        }
        if (dto.longitude() != null) {
            entidade.setLongitude(java.math.BigDecimal.valueOf(dto.longitude()));
        }

        if (dto.senha() != null && !dto.senha().isEmpty()) {
            entidade.setSenha(passwordEncoder.encode(dto.senha()));
        }

        repositorio.save(entidade);
        return UsuarioMapeador.paraDto(entidade);
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
