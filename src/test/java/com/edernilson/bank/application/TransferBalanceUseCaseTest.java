package com.edernilson.bank.application;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.edernilson.bank.ContainerConfigTests;
import com.edernilson.bank.application.responses.GetAccountBalance;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 06/05/2024, segunda-feira
 */
@SpringBootTest
@Transactional
@Testcontainers
class TransferBalanceUseCaseTest extends ContainerConfigTests {

    @Autowired
    private TransferBalanceUseCase transferBalanceUseCase;

    @Test
    void shouldTransferBalanceSuccessfull() {
        List<GetAccountBalance> getAccountBalances = transferBalanceUseCase.transferBalance(1L, 2L, 100.0);
        assertEquals(BigDecimal.valueOf(900.0), getAccountBalances.get(0).getCurrentBalance());
        assertEquals(BigDecimal.valueOf(2100.0), getAccountBalances.get(1).getCurrentBalance());
    }
}