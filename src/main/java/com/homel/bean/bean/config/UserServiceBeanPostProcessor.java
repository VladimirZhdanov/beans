package com.homel.bean.bean.config;

import com.homel.bean.bean.service.Event;
import com.homel.bean.bean.service.UserService;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class UserServiceBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof UserService) {
            System.out.println("postProcessBeforeInitialization: " + beanName);
            return createProxy(bean);
        }

        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof UserService) {
            System.out.println("postProcessAfterInitialization: " + beanName);
        }

        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    private Object createProxy(Object target) {
        ProxyFactory proxyFactory = new ProxyFactory(target);
        MethodBeforeAdvice advice = (method, args, target1) -> {
            Event event = method.getAnnotation(Event.class);
            if (event != null) {
                sendEventToKafka(method.getName(), event, args);
            };

        };

        proxyFactory.addAdvice(advice);
        return proxyFactory.getProxy();
    }

    private void sendEventToKafka(String methodName, Event event, Object[] args) {
        // Логика отправки события в Kafka
        System.out.println("Отправка события " + event.action() + " в Kafka для метода: " + methodName);
        // Здесь добавьте код для отправки события в Kafka
    }
}
