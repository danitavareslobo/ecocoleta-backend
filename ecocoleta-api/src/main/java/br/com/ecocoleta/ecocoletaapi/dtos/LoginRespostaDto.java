package br.com.ecocoleta.ecocoletaapi.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class LoginRespostaDto{

    private String tipo;
    private String token;


}
