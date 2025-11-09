package br.com.ecocoleta.ecocoletaapi.configuracao;

import br.com.ecocoleta.ecocoletaapi.entidades.UsuarioEntidade;
import br.com.ecocoleta.ecocoletaapi.enums.UsuarioPerfil;
import br.com.ecocoleta.ecocoletaapi.repositorio.UsuarioRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DadosColetores implements ApplicationRunner {

    private final UsuarioRepositorio usuarioRepositorio;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Iniciando cadastro coletores...");
        String[][] listColetores = {
                {"coletor1", "coletor1"},
                {"coletor2", "coletor2"},
                {"coletor3", "coletor3"}
        };
        for(String[] coletor : listColetores){
            String nomeUsuario = coletor[0];
            String senha = coletor[1];

            if(usuarioRepositorio.findByNomeUsuario(nomeUsuario).isEmpty()){
                UsuarioEntidade novoColetor = new UsuarioEntidade();
                novoColetor.setNomeUsuario(nomeUsuario);
                novoColetor.setSenha(passwordEncoder.encode(senha));
                novoColetor.setPerfil(UsuarioPerfil.COLETOR);
                novoColetor.setComplemento("-");
                novoColetor.setCep("-");
                novoColetor.setLogradouro("-");
                novoColetor.setCidade("-");
                novoColetor.setEstado("-");
                novoColetor.setBairro("-");
                novoColetor.setNumero("-");

                usuarioRepositorio.save(novoColetor);
                System.out.println("Coletor "+nomeUsuario+" cadastrado para teste.");
            }else {
                System.out.println("Coletor "+nomeUsuario+" existente.");
            }
        }
    }
}
