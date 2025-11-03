package br.com.ecocoleta.ecocoletaapi.repositorio;

import br.com.ecocoleta.ecocoletaapi.dtos.UsuarioRespostaDto;
import br.com.ecocoleta.ecocoletaapi.entidades.UsuarioEntidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepositorio extends JpaRepository<UsuarioEntidade, Long> {

    Optional<UsuarioRespostaDto> findByNomeUsuario(String nomeUsuario);

}
