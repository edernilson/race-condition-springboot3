package com.edernilson.bank;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.edernilson.bank.application.ListAccountUseCase;
import com.edernilson.bank.application.TransferBalanceUseCase;
import com.edernilson.bank.domain.ports.AccountRepository;
import com.edernilson.bank.domain.ports.UserRepository;

@SpringBootApplication
public class BankApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankApplication.class, args);
    }

    @Bean
    public ListAccountUseCase provideListAccountUseCase(AccountRepository repository, ModelMapper modelMapper) {
        return new ListAccountUseCase(repository, modelMapper);
    }

    @Bean
    public TransferBalanceUseCase provideTransferBalanceUseCase(AccountRepository repository, UserRepository userRepository, ModelMapper modelMapper) {
        return new TransferBalanceUseCase(repository, userRepository, modelMapper);
    }

}