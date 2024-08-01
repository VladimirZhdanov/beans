package com.homel.bean.bean.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

// Метод postProcessBeanFactory из интерфейса BeanFactoryPostProcessor используется для кастомизации BeanFactory до того, как она будет использована для создания бинов.
// Этот метод вызывается после того, как все бины были зарегистрированы в BeanFactory, но до того, как они были фактически созданы.
// Некоторые практические случаи, когда может потребоваться использовать этот метод:
//  - Изменение свойств бинов: можно изменить значения свойств бинов, которые были зарегистрированы в BeanFactory.
//  - Установка зависимостей: можно установить зависимости между бинами, которые не могут быть установлены с помощью аннотаций или XML-конфигурации.
//  - Изменение области видимости: можно изменить область видимости бинов, например, чтобы сделать их прототипами вместо синглтонов.
//  - Изменение типа бинов: можно изменить тип бинов, например, чтобы заменить один бин другим.
//  - Установка фабричного метода: можно установить фабричный метод для создания бинов, который не может быть установлен с помощью аннотаций или XML-конфигурации.
// В целом, метод postProcessBeanFactory может быть использован для любых кастомизаций, которые не могут быть выполнены с помощью аннотаций или XML-конфигурации.
@Component
public class CustomBeanFactory implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");

        //Установка значения свойства:
        //beanDefinition.getPropertyValues().add("propertyName", "propertyValue");
        //Установка значения конструктора:
        //beanDefinition.getConstructorArgumentValues().addIndexedArgumentValue(0, new CarService());
        //Установка зависимостей:
        //beanDefinition.setDependsOn("carService");
        //Установка области видимости:
        //beanDefinition.setScope(BeanDefinition.SCOPE_SINGLETON);
        //Установка фабричного метода:
        //beanDefinition.setFactoryMethodName(factoryMethodName);
        //Установка типа бина:
        //beanDefinition.setBeanClassName(beanClassName);
        //Установка флага ленивой инициализации:
        //beanDefinition.setLazyInit(true);
        //Установка флага автосвязывания:
        //beanDefinition.setAutowireCandidate(true);

//        for (String beanName : beanFactory.getBeanDefinitionNames()) {
//            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
//            System.out.println(beanDefinition.getBeanClassName());
//            // Manipulate the beanDefiniton or whatever you need to do
//        }
    }
}
