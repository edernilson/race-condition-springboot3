package com.edernilson.bank.adapters.out;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.edernilson.bank.domain.model.UserEntity;
import com.edernilson.bank.domain.ports.UserRepository;

import jakarta.persistence.EntityManager;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 06/05/2024, segunda-feira
 */
@Repository
public class UserJpaRepository implements UserRepository {
    private final EntityManager entityManager;

    public UserJpaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<UserEntity> findAll() {
        return entityManager
                .createQuery("SELECT u FROM UserEntity u", UserEntity.class)
                .getResultList();
    }

    @Override
    public Optional<UserEntity> findById(Long id) {
        return Optional.ofNullable(entityManager.find(UserEntity.class, id));
    }
}