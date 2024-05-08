package com.edernilson.bank.application.responses;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 06/05/2024, segunda-feira
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetAccountBalance {
    private String name;
    private BigDecimal lastBalance;
    private BigDecimal currentBalance;
}