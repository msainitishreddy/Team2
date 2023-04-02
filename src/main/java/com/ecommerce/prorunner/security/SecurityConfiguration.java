package com.ecommerce.prorunner.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/home","/user-api/*","/product-api/*","/", "/user-register","/js/**", "/css/**", "/images/**","/gif/**","/error/**")
                .permitAll()
                .antMatchers("/products/**","/products/**/**").permitAll()
                .antMatchers("/contact-us","/about-us","/support","/forgot-pw").permitAll()
                .antMatchers("/add-to-cart/**","/my-cart","/remove-cart-item/**","/my-cart/place-order").hasAnyAuthority( "USER")
                .antMatchers("/add-product").hasAnyAuthority( "ADMIN")
                .antMatchers("/*").hasAnyAuthority("USER", "ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin(form -> form.defaultSuccessUrl("/home")
                        .loginPage("/login")
                        .usernameParameter("email")
                        .failureUrl("/login?error=true")
                        .permitAll()).logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/home")
                .permitAll();
    }
}
