package com.edernilson.bank.application;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;

import com.edernilson.bank.application.responses.GetAccountResponse;
import com.edernilson.bank.domain.ports.AccountRepository;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 06/05/2024, segunda-feira
 */
public class ListAccountUseCase {
    private final AccountRepository repository;
    private final ModelMapper modelMapper;

    public ListAccountUseCase(AccountRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Transactional(readOnly = true)
    public List<GetAccountResponse> getAccounts() {
        return repository.findAll().stream()
                .map(account -> modelMapper.map(account, GetAccountResponse.class))
                .collect(Collectors.toList());
    }
}