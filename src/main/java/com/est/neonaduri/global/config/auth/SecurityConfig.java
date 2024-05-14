package com.est.neonaduri.global.config.auth;

import com.est.neonaduri.domain.users.domain.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig{
    private final CustomOAuth2UserService customOAuth2UserService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeHttpRequests()
                    .requestMatchers("/neonaduri","/", "/css/**", "images/**", "/js/**").permitAll() //모두 접근 가능
                    .requestMatchers("/posts").hasRole(Role.USER.name()) //user만 접근 가능
                    .anyRequest().authenticated() //나머지 URL 로그인 사용자에게만 허용
                .and()
                .logout()
                    .logoutSuccessUrl("/neonaduri") //로그아웃시 이동
                .and()
                .oauth2Login()
                    .userInfoEndpoint() //로그인 성공 이후 사용자 정보 가져올 떄의 설정
                        .userService(customOAuth2UserService);

        return http.build();
    }

}
