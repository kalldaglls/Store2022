package com.forgeeks.SpringDZ5.core.configs;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final JwtRequestFilter jwtRequestFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()//Пишем так, если нет генерации фронта на бэке
                .cors().disable()//НОВОЕ!!!
                .authorizeRequests()
//                .antMatchers("/api/v1/orders/**").authenticated()//здесь приоритет имеет значение - перед первым and!
//                .antMatchers("/api/v1/profile").authenticated()
//                .antMatchers("/h2-console/**").permitAll()//Разрешаем всем доступ к консоли!
//                .antMatchers("/api/v1/cart").authenticated()
                .antMatchers("/api/v1/user").authenticated()
                .antMatchers("app-core/auth/about").authenticated()
                .antMatchers("/api/v1/orders/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)//отключаем сессии и сохранение состояния именно для безопасности!
                .and()
                .headers().frameOptions().disable()// дополнительный header, чтобы работала консоль!
                .and()
                .exceptionHandling()//обработка исключений!
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
