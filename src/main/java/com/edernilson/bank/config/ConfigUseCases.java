package com.edernilson.bank.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.edernilson.bank.application.ListAccountUseCase;
import com.edernilson.bank.application.ListUserUseCase;
import com.edernilson.bank.application.TransferBalanceUseCase;
import com.edernilson.bank.domain.ports.AccountRepository;
import com.edernilson.bank.domain.ports.UserRepository;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 08/05/2024, quarta-feira
 */
@Configuration
public class ConfigUseCases {

    @Bean
    public ListAccountUseCase provideListAccountUseCase(AccountRepository repository, ModelMapper modelMapper) {
        return new ListAccountUseCase(repository, modelMapper);
    }

    @Bean
    public TransferBalanceUseCase provideTransferBalanceUseCase(AccountRepository repository, UserRepository userRepository) {
        return new TransferBalanceUseCase(repository, userRepository);
    }

    @Bean
    public ListUserUseCase provideListUserUseCase(UserRepository repository, ModelMapper modelMapper) {
        return new ListUserUseCase(repository, modelMapper);
    }

}