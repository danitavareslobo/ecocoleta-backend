package br.com.ecocoleta.ecocoletaapi.repositorio;

import br.com.ecocoleta.ecocoletaapi.entidades.SolicitacaoColetaEntidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitacaoColetaRepositorio extends JpaRepository<SolicitacaoColetaEntidade, Long> {
}
