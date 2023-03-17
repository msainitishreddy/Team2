package com.ecommerce.prorunner.service;

import com.ecommerce.prorunner.entity.ProRunnerUserEntity;
import com.ecommerce.prorunner.repository.ProRunnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ProRunnerUserServiceImpl implements ProRunnerUserService{

    @Autowired
    private ProRunnerRepository proRunnerRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public ProRunnerUserEntity createOrder(ProRunnerUserEntity proRunnerUserEntity) {
        if(proRunnerUserEntity.getRole()==null){
            proRunnerUserEntity.setRole("USER");
        }
        proRunnerUserEntity.setPassword(passwordEncoder.encode(proRunnerUserEntity.getPassword()));
        return proRunnerRepository.save(proRunnerUserEntity);
    }

    @Override
    public void deleteProduct(Long Id) {

    }
}
