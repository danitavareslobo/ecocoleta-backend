package br.com.ecocoleta.ecocoletaapi.repositorio;

import br.com.ecocoleta.ecocoletaapi.entidades.UsuarioEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


import java.util.Optional;
@Repository
public interface UsuarioRepositorio extends JpaRepository<UsuarioEntidade, Long> {

    Optional<UsuarioEntidade> findByNomeUsuario(String nomeUsuario);

}
