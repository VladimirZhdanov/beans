package com.homel.bean.bean.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private CarService carService;

    public UserService(CarService carService) {
        System.out.println("Constructor UserService");
        this.carService = carService;
    }

    @Event(action = "CREATE")
    public void createUser() {
        System.out.println("Call createUser");
    }

    @Event(action = "READ")
    public void getUser() {
        System.out.println("Call getUser");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstruct UserService");
    };

    @PreDestroy
    public void preDestroy() {
        System.out.println("PreDestroy UserService");
    };
}
