package com.edernilson.bank.adapters.in;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.edernilson.bank.ContainerConfigTests;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 09/05/2024, quinta-feira
 */
@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class ListAccountsApiTest extends ContainerConfigTests {

    @Autowired
    private MockMvc mvc;

    @Test
    void shouldListAccountsApiReturnSuccessFull() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/accounts")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*].userName").isNotEmpty());
    }
}