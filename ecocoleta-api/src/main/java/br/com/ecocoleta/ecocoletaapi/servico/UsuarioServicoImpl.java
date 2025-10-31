package br.com.ecocoleta.ecocoletaapi.servico;



//Criar endpoint para criação novos de Usuarios (Usuário/Cadastro):
// Cria um novo Usuário com perfil Residencial e
// associa seu Endereço e coordenadas (POST /api/usuarios).


import br.com.ecocoleta.ecocoletaapi.dtos.UsuarioRequisicaoDto;
import br.com.ecocoleta.ecocoletaapi.dtos.UsuarioRespostaDto;
import br.com.ecocoleta.ecocoletaapi.entidades.UsuarioEntidade;
import br.com.ecocoleta.ecocoletaapi.mapeador.UsuarioMapeador;
import br.com.ecocoleta.ecocoletaapi.repositorio.UsuarioRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UsuarioServicoImpl implements UsuarioServico{


    private final UsuarioRepositorio repositorio;


}
