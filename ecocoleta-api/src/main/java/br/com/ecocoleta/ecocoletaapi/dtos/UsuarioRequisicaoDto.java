package br.com.ecocoleta.ecocoletaapi.dtos;

import br.com.ecocoleta.ecocoletaapi.enums.UsuarioPerfil;

public record UsuarioRequisicaoDto (

    String nomeUsuario,
    String senha,
    String cep,
    String logradouro,
    String estado,
    String cidade,
    String bairro,
    String numero,
    String complemento
){}
