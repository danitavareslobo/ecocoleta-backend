package br.com.ecocoleta.ecocoletaapi.repositorio;

import br.com.ecocoleta.ecocoletaapi.entidades.UsuarioEntidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<UsuarioEntidade, Long> {
}
