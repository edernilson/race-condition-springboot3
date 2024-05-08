package com.edernilson.bank.application;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;

import com.edernilson.bank.application.responses.GetAccountBalance;
import com.edernilson.bank.domain.exception.ResponseStatusException;
import com.edernilson.bank.domain.model.AccountEntity;
import com.edernilson.bank.domain.model.UserEntity;
import com.edernilson.bank.domain.ports.AccountRepository;
import com.edernilson.bank.domain.ports.UserRepository;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 06/05/2024, segunda-feira
 */
public class TransferBalanceUseCase {
    private final AccountRepository repository;
    private final UserRepository userRepository;

    public TransferBalanceUseCase(AccountRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Transactional
    public List<GetAccountBalance> transferBalance(Long accountOrigId, Long accountDestId, double value) {
        List<GetAccountBalance> result = new ArrayList<>();
        if (value <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid value");
        }
        AccountEntity accountOrig = repository.findById(accountOrigId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Origin account not found"));
        AccountEntity accountDest = repository.findById(accountDestId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Destine account not found"));

        UserEntity userOrig = userRepository.findById(accountOrig.getUser().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Origin user not found"));
        UserEntity userDest = userRepository.findById(accountDest.getUser().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Destine user not found"));

        GetAccountBalance origBalance = new GetAccountBalance();
        GetAccountBalance destBalance = new GetAccountBalance();

        origBalance.setName(userOrig.getName());
        origBalance.setLastBalance(accountOrig.getBalance());

        destBalance.setName(userDest.getName());
        destBalance.setLastBalance(accountDest.getBalance());

        BigDecimal amount = BigDecimal.valueOf(value);
        if (accountOrig.getBalance().compareTo(amount) >= 1) {
            accountOrig.setBalance(accountOrig.getBalance().subtract(amount));
            AccountEntity accountSuccessTransfer = repository.save(accountOrig);
            origBalance.setCurrentBalance(accountSuccessTransfer.getBalance());

            accountDest.setBalance(accountDest.getBalance().add(amount));
            AccountEntity accountSuccessReceive = repository.save(accountDest);
            destBalance.setCurrentBalance(accountSuccessReceive.getBalance());
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Insufficient balance");
        }

        result.add(origBalance);
        result.add(destBalance);

        return result;
    }
}