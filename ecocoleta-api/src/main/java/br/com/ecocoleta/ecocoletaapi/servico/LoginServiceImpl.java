package br.com.ecocoleta.ecocoletaapi.servico;

import br.com.ecocoleta.ecocoletaapi.configuracao.JwtConfig;
import br.com.ecocoleta.ecocoletaapi.dtos.LoginRequisicaoDto;
import br.com.ecocoleta.ecocoletaapi.dtos.LoginRespostaDto;
import br.com.ecocoleta.ecocoletaapi.entidades.UsuarioEntidade;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService{

    private final JwtConfig jwtConfig;
    private final AuthenticationManager authenticationManager;

    @Override
    public LoginRespostaDto autenticar(LoginRequisicaoDto dto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.nomeUsuario(), dto.senha()
                )
        );
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new BadCredentialsException("Usuario ou senha invalidos.");
        }

        UsuarioEntidade usuarioEntidade = (UsuarioEntidade) authentication.getPrincipal();

        String token = jwtConfig.generateToken(usuarioEntidade);


        return LoginRespostaDto.builder()
                .tipo("Bearer")
                .token(token)
                .build();
    }
}
