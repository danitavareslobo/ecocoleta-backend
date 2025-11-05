package br.com.ecocoleta.ecocoletaapi.servico;

import br.com.ecocoleta.ecocoletaapi.dtos.LoginRequisicaoDto;
import br.com.ecocoleta.ecocoletaapi.dtos.LoginRespostaDto;
import br.com.ecocoleta.ecocoletaapi.entidades.UsuarioEntidade;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService{

    private final UsuarioServico servico;
    private final PasswordEncoder passwordEncoder;


    @Override
    public LoginRespostaDto autenticar(LoginRequisicaoDto dto) {
        UserDetails usuario = servico.loadUserByUsername(dto.nomeUsuario());


        //Validar senha
        boolean senhaConfere = passwordEncoder.matches(dto.senha(), usuario.getPassword());
        if(!senhaConfere){
            throw new RuntimeException("Deu merda");
        }

        String codificar = usuario.getUsername() + ":" +dto.senha();
        String token = Base64.getEncoder().encodeToString(codificar.getBytes());

        return LoginRespostaDto.builder()
                .tipo("Basic")
                .token(token)
                .build();
    }
}
