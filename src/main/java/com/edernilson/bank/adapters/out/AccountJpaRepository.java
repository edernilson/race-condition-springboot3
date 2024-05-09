package com.edernilson.bank.adapters.out;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import com.edernilson.bank.domain.model.AccountEntity;
import com.edernilson.bank.domain.ports.AccountRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 06/05/2024, segunda-feira
 */
@Repository
public class AccountJpaRepository implements AccountRepository {
    private final EntityManager entityManager;

    public AccountJpaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<AccountEntity> findAll() {
        return entityManager
                .createQuery("SELECT a FROM AccountEntity a LEFT JOIN FETCH a.user", AccountEntity.class)
                .getResultList();
    }

    @Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
    @Override
    public Optional<AccountEntity> findById(Long id) {
        return Optional.ofNullable(entityManager.find(AccountEntity.class, id));
    }

    @Override
    public AccountEntity save(AccountEntity id) {
        entityManager.persist(id);
        entityManager.flush();
        return id;
    }
}