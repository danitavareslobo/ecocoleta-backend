package br.com.ecocoleta.ecocoletaapi.repositorio;

import br.com.ecocoleta.ecocoletaapi.entidades.SolicitacaoColetaEntidade;
import br.com.ecocoleta.ecocoletaapi.enums.SolicitacaoColetaStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolicitacaoColetaRepositorio extends JpaRepository<SolicitacaoColetaEntidade, Long> {

    List<SolicitacaoColetaEntidade> findAllByStatus(SolicitacaoColetaStatus status);

}
