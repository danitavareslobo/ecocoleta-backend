package br.com.ecocoleta.ecocoletaapi.dtos;

import br.com.ecocoleta.ecocoletaapi.enums.UsuarioPerfil;

import java.math.BigDecimal;

public record UsuarioRespostaDto (

        Long id,
        String nomeUsuario,
        UsuarioPerfil perfil,
        String cep,
        String logradouro,
        String cidade,
        String estado,
        String bairro,
        String numero,
        String complemento,
        BigDecimal latitude,
        BigDecimal longitude

){}