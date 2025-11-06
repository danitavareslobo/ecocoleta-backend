package br.com.ecocoleta.ecocoletaapi.mapeador;

import br.com.ecocoleta.ecocoletaapi.dtos.UsuarioRequisicaoDto;
import br.com.ecocoleta.ecocoletaapi.dtos.UsuarioRespostaDto;
import br.com.ecocoleta.ecocoletaapi.entidades.UsuarioEntidade;

public class UsuarioMapeador {

    private UsuarioMapeador(){};


    public static UsuarioRespostaDto paraDto(UsuarioEntidade entidade){
        return new UsuarioRespostaDto(
                entidade.getId(),
                entidade.getNomeUsuario(),
                entidade.getPerfil(),
                entidade.getCep(),
                entidade.getLogradouro(),
                entidade.getEstado(),
                entidade.getCidade(),
                entidade.getBairro(),
                entidade.getNumero(),
                entidade.getComplemento(),
                entidade.getLongitude(),
                entidade.getLatitude()
        );
    }

    public static void paraEntidade(UsuarioEntidade entidade, UsuarioRequisicaoDto dto){
        entidade.setNomeUsuario(dto.nomeUsuario());
        entidade.setCep(dto.cep());
        entidade.setLogradouro(dto.logradouro());
        entidade.setCidade(dto.cidade());
        entidade.setEstado(dto.estado());
        entidade.setBairro(dto.bairro());
        entidade.setNumero(dto.numero());
        entidade.setComplemento(dto.complemento());
    }


}
