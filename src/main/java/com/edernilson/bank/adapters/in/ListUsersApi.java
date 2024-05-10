package com.edernilson.bank.adapters.in;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edernilson.bank.application.ListUserUseCase;
import com.edernilson.bank.application.responses.GetUsersResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 08/05/2024, quarta-feira
 */
@Tag(name = "Users", description = "List users")
@RestController
@RequestMapping("/users")
public record ListUsersApi(ListUserUseCase useCase) {

    @GetMapping
    public List<GetUsersResponse> listAccounts() {
        return useCase.getUsers();
    }
}