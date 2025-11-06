package br.com.ecocoleta.ecocoletaapi.servico;

import br.com.ecocoleta.ecocoletaapi.dtos.LoginRequisicaoDto;
import br.com.ecocoleta.ecocoletaapi.dtos.LoginRespostaDto;

public interface LoginService {

    LoginRespostaDto autenticar(LoginRequisicaoDto dto);
}
