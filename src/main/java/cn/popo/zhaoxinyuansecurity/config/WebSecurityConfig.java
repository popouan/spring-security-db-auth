package cn.popo.zhaoxinyuansecurity.config;

import cn.popo.zhaoxinyuansecurity.service.AppUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    AppUserDetailsService appUserDetailsService;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.userDetailsService(appUserDetailsService);

        httpSecurity.authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/css/**", "/js/**", "/image/**").permitAll()
                .requestMatchers("/admin").hasRole("admin")
                .requestMatchers("/normal").hasAnyRole("admin", "normal")
                .anyRequest().authenticated()
        );

        httpSecurity.formLogin(form -> form
                .loginPage("/login")
                .permitAll()
        );

        httpSecurity.exceptionHandling(handling -> handling
                .accessDeniedPage("/403")
        );

        return httpSecurity.build();
    }
}