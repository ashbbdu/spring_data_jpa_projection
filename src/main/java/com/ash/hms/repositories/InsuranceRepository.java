package com.ash.hms.repositories;

import com.ash.hms.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InsuranceRepository extends JpaRepository<UserEntity , Long> {

}
