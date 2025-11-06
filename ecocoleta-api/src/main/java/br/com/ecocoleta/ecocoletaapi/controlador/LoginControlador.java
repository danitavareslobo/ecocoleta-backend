package br.com.ecocoleta.ecocoletaapi.controlador;


import br.com.ecocoleta.ecocoletaapi.dtos.LoginRequisicaoDto;
import br.com.ecocoleta.ecocoletaapi.dtos.LoginRespostaDto;
import br.com.ecocoleta.ecocoletaapi.servico.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api")
public class LoginControlador {

    private final LoginService servico;

    @PostMapping("login")
    public LoginRespostaDto post(@RequestBody LoginRequisicaoDto dto){
        return servico.autenticar(dto);
    }

}
