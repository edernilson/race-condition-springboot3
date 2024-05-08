package com.edernilson.bank.application;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.edernilson.bank.ContainerConfigTests;
import com.edernilson.bank.application.responses.GetAccountResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 06/05/2024, segunda-feira
 */
@SpringBootTest
@Testcontainers
//@Transactional(readOnly = true)
public class ListAccountsUseCaseTest extends ContainerConfigTests {

    @Autowired
    private ListAccountUseCase listAccountUseCase;

    @Test
    public void shouldReturnListWith3Accounts() {
        List<GetAccountResponse> accounts = listAccountUseCase.getAccounts();
        assertEquals(3, accounts.size());
    }
}