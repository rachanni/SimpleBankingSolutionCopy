package com.banking.opeartion.repository;

import com.banking.opeartion.entity.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInformationRepository extends JpaRepository<UserInformation,Long> {
    Optional<UserInformation> findByUserName(String username);
}
