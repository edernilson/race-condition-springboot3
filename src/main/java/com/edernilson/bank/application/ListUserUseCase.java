package com.edernilson.bank.application;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.edernilson.bank.application.responses.GetUsersResponse;
import com.edernilson.bank.domain.ports.UserRepository;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 06/05/2024, segunda-feira
 */
public record ListUserUseCase(UserRepository repository, ModelMapper modelMapper) {

    public List<GetUsersResponse> getUsers() {
        return repository.findAll().stream()
                .map(user -> modelMapper.map(user, GetUsersResponse.class))
                .collect(Collectors.toList());
    }
}