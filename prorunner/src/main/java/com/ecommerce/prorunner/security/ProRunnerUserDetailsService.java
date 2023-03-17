package com.ecommerce.prorunner.security;

import com.ecommerce.prorunner.entity.ProRunnerUserEntity;
import com.ecommerce.prorunner.repository.ProRunnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ProRunnerUserDetailsService implements UserDetailsService {
    @Autowired
    private ProRunnerRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        ProRunnerUserEntity proRunnerUserEntity = userRepository.findByEmail(email);
        if (proRunnerUserEntity == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");
        }
        return new ProRunnerUser(proRunnerUserEntity);
    }
}