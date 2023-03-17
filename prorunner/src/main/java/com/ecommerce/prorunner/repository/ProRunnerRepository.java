package com.ecommerce.prorunner.repository;

import com.ecommerce.prorunner.entity.ProRunnerUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProRunnerRepository extends JpaRepository<ProRunnerUserEntity,Long> {
    //ProRunnerUserEntity findProRunnerUserEntityByEmail(String email);

    ProRunnerUserEntity save(ProRunnerUserEntity proRunnerUserEntity);
    void save(Long id);

    ProRunnerUserEntity findByEmail(String email);
}
