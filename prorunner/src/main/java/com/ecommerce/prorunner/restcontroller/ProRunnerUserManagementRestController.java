package com.ecommerce.prorunner.restcontroller;

import com.ecommerce.prorunner.entity.ProRunnerUserEntity;
import com.ecommerce.prorunner.service.ProRunnerUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping ("/user-api")
public class ProRunnerUserManagementRestController {

    @Autowired
    private ProRunnerUserService proRunnerUserService;

    @PostMapping("/create")
    public ResponseEntity<ProRunnerUserEntity> createUser(@RequestBody ProRunnerUserEntity proRunnerUserEntity){

        ProRunnerUserEntity response = proRunnerUserService.createOrder(proRunnerUserEntity);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
