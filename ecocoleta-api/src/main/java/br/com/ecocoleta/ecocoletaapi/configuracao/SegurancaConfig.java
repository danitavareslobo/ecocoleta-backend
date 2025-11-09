package br.com.ecocoleta.ecocoletaapi.configuracao;


import br.com.ecocoleta.ecocoletaapi.enums.UsuarioPerfil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SegurancaConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, JwtFiltro jwtFiltro) throws Exception {
        http
                .cors(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable)
                .sessionManagement((s) -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
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
                )
                .addFilterBefore(jwtFiltro, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:5173"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
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
