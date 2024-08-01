package com.homel.bean.bean.config;

import com.homel.bean.bean.service.CarService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public CarService carService() {
        return new CarService();
    }
}
