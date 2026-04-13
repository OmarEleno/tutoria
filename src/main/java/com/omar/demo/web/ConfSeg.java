package com.omar.demo.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration  //Clase de configuracion para Spring
@EnableWebSecurity  //Activa el sistema de seguridad web de Spring
public class ConfSeg {

    @Bean //El objeto que retorna debe ser administrado por Spring, crea el objeto una sola vez.
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean //Es la cadena de filtro que intercepta todas las peticiones http
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        //Metodo para darle roles, login´s al proyecto
        http.authorizeHttpRequests(auth -> auth //auth es el configurador de reglas
                //si la url es... - /** = cualquier cosa - Solo los usuarios con esa autoridad pueden entrar
                        .requestMatchers("/consultor/**").hasAnyAuthority("DIRECTOR", "SUBDIRECTOR ACADEMICO")
                        .requestMatchers("/consultor/**").hasAllAuthorities("DIRECTOR", "SUBDIRECTOR ACADEMICO")
                        .requestMatchers("/director/**").hasAuthority("DIRECTOR")
                .requestMatchers("/subdirector/**").hasAuthority("SUBDIRECTOR ACADEMICO")
                        .requestMatchers("/jefeDepDA/**").hasAuthority("JEFE DE DEPARTAMENTO DE DESARROLLO ACADEMICO")
                        .requestMatchers("/coorIns/**").hasAuthority("COORDINADOR INSTITUCIONAL DE TUTORIAS")
                        .requestMatchers("/jefeDepA/**").hasAuthority("JEFE DE DEPARTAMENTO ACADEMICO")
                        .requestMatchers("/coorDep/**").hasAuthority("COORDINADOR DEPARTAMENTAL DE TUTORIAS")
                        .requestMatchers("/tutor/**").hasAuthority("TUTOR")
                        .requestMatchers("/tutorado/**").hasAuthority("TUTORADO")



                        .requestMatchers("/login", "/css/**").permitAll() //Rutas publicas

                .anyRequest().authenticated() //Las peticiones que me faltaron ocupan login pero no rol
        )

                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/", true)
                        .permitAll()
                )

                .logout(logout ->logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        /*.logoutSuccessUrl("/login")*/
                        .permitAll())

                .exceptionHandling(ex -> ex
                        .accessDeniedPage("/error")
                );
        return http.build();
    }
}
