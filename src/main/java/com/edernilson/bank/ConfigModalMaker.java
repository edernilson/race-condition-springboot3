package com.edernilson.bank;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 06/05/2024, segunda-feira
 */
@Configuration
public class ConfigModalMaker {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}