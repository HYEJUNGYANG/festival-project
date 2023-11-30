package com.festival.festival.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Slf4j
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http
                .csrf(CsrfConfigurer::disable)
                .authorizeHttpRequests((authorizeRequests) ->
                                authorizeRequests
//                                .requestMatchers(new AntPathRequestMatcher("/qna/**")).authenticated() //로그인한 유저만 접속가능한 링크
                                        //.requestMatchers(new AntPathRequestMatcher("/admin_page/**")).hasRole("ADMIN") //관리자만 접속가능한 링크*/
//                                .requestMatchers(new AntPathRequestMatcher("/admin_page/admin_login")).permitAll()
                                        .anyRequest().permitAll()
                )
                .formLogin(login -> login
                        .loginPage("/login")
                        .usernameParameter("id")
                        .passwordParameter("pw")
                        .loginProcessingUrl("/loginProcess")
                        //.defaultSuccessUrl("/admin_page/admin_main")
                        .successHandler(new CustomLoginSuccessHandler())
                )
                .logout((logout) -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/").permitAll()
                )
                .getOrBuild();
    }
}
