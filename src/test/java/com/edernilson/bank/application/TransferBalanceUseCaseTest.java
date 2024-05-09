package com.edernilson.bank.application;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.edernilson.bank.ContainerConfigTests;
import com.edernilson.bank.application.responses.GetAccountBalance;
import com.edernilson.bank.domain.exception.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @ParameterizedTest
    @CsvSource({"-1", "0", "5000"})
    void shouldTransferBalanceWithLimitErrorException(double value) {
        Exception exception = assertThrows(ResponseStatusException.class, () -> {
            transferBalanceUseCase.transferBalance(1L, 2L, value);
        });
        String expectedMessage = "Invalid value|Insufficient balance";
        String actualMessage = exception.getMessage();

        assertTrue(expectedMessage.contains(actualMessage));
    }

    @RepeatedTest(1000)
    void shouldTransferBalanceSuccessfullWithRepeatedTimes() {
        transferBalanceUseCase.transferBalance(1L, 3L, 1.0);
    }
}