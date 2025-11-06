package br.com.ecocoleta.ecocoletaapi.repositorio;

import br.com.ecocoleta.ecocoletaapi.entidades.ItemColetaEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemColetaRepositorio extends JpaRepository<ItemColetaEntidade, Long> {
}
