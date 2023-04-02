package com.ecommerce.prorunner.security;

import com.ecommerce.prorunner.entity.ProRunnerUserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class ProRunnerUser implements UserDetails {
    private final ProRunnerUserEntity proRunnerUserEntity;

    public ProRunnerUser(ProRunnerUserEntity user) {
        this.proRunnerUserEntity = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(proRunnerUserEntity.getRole()));
    }

    @Override
    public String getPassword() {
        return proRunnerUserEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return proRunnerUserEntity.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}