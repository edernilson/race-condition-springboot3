package com.edernilson.bank.domain.ports;

import java.util.List;
import java.util.Optional;

import com.edernilson.bank.domain.model.UserEntity;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 06/05/2024, segunda-feira
 */
public interface UserRepository {
    List<UserEntity> findAll();

    Optional<UserEntity> findById(Long id);
}