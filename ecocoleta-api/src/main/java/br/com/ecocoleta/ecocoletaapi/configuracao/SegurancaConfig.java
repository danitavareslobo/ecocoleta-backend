package br.com.ecocoleta.ecocoletaapi.configuracao;


import br.com.ecocoleta.ecocoletaapi.enums.UsuarioPerfil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SegurancaConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults())
                .formLogin(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        //criar login e logout ainda
                        .requestMatchers("/api/login", "/api/logout", "/api/usuarios" ).permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/coletas").hasAuthority(UsuarioPerfil.RESIDENCIAL.name())
                        .requestMatchers(HttpMethod.GET, "/api/coletas/minhas").hasAuthority(UsuarioPerfil.RESIDENCIAL.name())
                        .requestMatchers(HttpMethod.PUT, "/api/coletas/{id}").hasAuthority(UsuarioPerfil.RESIDENCIAL.name())
                        .requestMatchers(HttpMethod.PATCH, "/api/coletas/{id}/cancelar").hasAuthority(UsuarioPerfil.RESIDENCIAL.name())
                        .requestMatchers(HttpMethod.GET, "/api/coletas").hasAuthority(UsuarioPerfil.COLETOR.name())
                        .requestMatchers(HttpMethod.PATCH, "/api/coletas/{id}/coletar").hasAuthority(UsuarioPerfil.COLETOR.name())
                        .requestMatchers(HttpMethod.PATCH, "/api/coletas/{id}/feedback").hasAuthority(UsuarioPerfil.COLETOR.name())
                        .requestMatchers(HttpMethod.PATCH, "/api/coletas/{id}/finalizar").hasAuthority(UsuarioPerfil.COLETOR.name())
                        .anyRequest().authenticated()
                );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


//    //em memoria para teste, sem uso
//    @Bean
//    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
//        String password = encoder.encode("123");
//
//        UserDetails usuario = User.withUsername("user")
//                .password(password)
//                .roles(UsuarioPerfil.RESIDENCIAL.name())
//                .build();
//
//        UserDetails admin = User.withUsername("adm")
//                .password(password)
//                .roles(UsuarioPerfil.COLETOR.name())
//                .build();
//
//        return new InMemoryUserDetailsManager(usuario, admin);
//    }




}
