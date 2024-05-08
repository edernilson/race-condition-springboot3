package com.edernilson.bank.domain.ports;

import java.util.List;
import java.util.Optional;

import com.edernilson.bank.domain.model.AccountEntity;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 06/05/2024, segunda-feira
 */
public interface AccountRepository {
    List<AccountEntity> findAll();

    Optional<AccountEntity> findById(Long accountOrig);

    AccountEntity save(AccountEntity accountOrig);
}