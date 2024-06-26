package com.edernilson.bank.adapters.in;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edernilson.bank.application.ListAccountUseCase;
import com.edernilson.bank.application.responses.GetAccountResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 08/05/2024, quarta-feira
 */
@Tag(name = "Accounts", description = "List account")
@RestController
@RequestMapping("/accounts")
public record ListAccountsApi(ListAccountUseCase useCase) {

    @GetMapping
    public List<GetAccountResponse> listAccounts() {
        return useCase.getAccounts();
    }
}