package br.com.ecocoleta.ecocoletaapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UsuarioPerfil {
    RESIDENCIAL("RESIDENCIAL"),
    COLETOR("COLETOR");


    private final String nome;
}
