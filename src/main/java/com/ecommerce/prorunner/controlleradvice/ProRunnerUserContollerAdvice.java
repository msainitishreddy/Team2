package com.ecommerce.prorunner.controlleradvice;

import com.ecommerce.prorunner.entity.ProRunnerUserEntity;
import com.ecommerce.prorunner.repository.ProRunnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;

@ControllerAdvice
public class ProRunnerUserContollerAdvice {

    @Autowired
    private ProRunnerRepository proRunnerRepository;

    @ModelAttribute("proRunnerUser")
    public ProRunnerUserEntity getCurrentUser(Principal principal){
        return  principal == null ? null :proRunnerRepository.findByEmail(principal.getName());
    }
}
