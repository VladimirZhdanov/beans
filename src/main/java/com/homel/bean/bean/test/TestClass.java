package com.homel.bean.bean.test;

import com.homel.bean.bean.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestClass  implements ApplicationListener<ContextRefreshedEvent> {

    private final UserService userService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        System.out.println(userService);

        userService.createUser();
        userService.getUser();
    }
}
