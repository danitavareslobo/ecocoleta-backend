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



    //GET PARA TESTES
    @Override
    public List<UsuarioRespostaDto> buscarTodos(){
        List<UsuarioEntidade> listaEntidades = repositorio.findAll();
        List<UsuarioRespostaDto> listaResposta = new ArrayList<>();

        for(UsuarioEntidade entidade : listaEntidades){
            UsuarioRespostaDto respostaDto = UsuarioMapeador.paraDto(entidade);
            listaResposta.add(respostaDto);
        }

        return listaResposta;
    }

    @Override
    public UsuarioRespostaDto criar(UsuarioRequisicaoDto dto) {
        UsuarioEntidade entidade = salvarEntidade(new UsuarioEntidade(), dto);
        return UsuarioMapeador.paraDto(entidade);
    }

    public UsuarioEntidade salvarEntidade(UsuarioEntidade entidade, UsuarioRequisicaoDto dto){
        UsuarioMapeador.paraEntidade(entidade, dto);
        return repositorio.save(entidade);
    }


}
