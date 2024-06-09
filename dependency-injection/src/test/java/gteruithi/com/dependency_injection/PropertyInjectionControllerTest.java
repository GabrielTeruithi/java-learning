package gteruithi.com.dependency_injection;

import gteruithi.com.dependency_injection.controllers.PropertyInjectionController;
import gteruithi.com.dependency_injection.services.GreetingServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PropertyInjectionControllerTest {

    @Autowired
    PropertyInjectionController propertyInjectionController;
//    @BeforeEach
//    void setUp() {
//        propertyInjectionController = new PropertyInjectionController();
//        propertyInjectionController.greetingService = new GreetingServiceImpl();
//    }

    @Test
    void sayHello() {
        System.out.println(propertyInjectionController.sayHello());
    }
}
