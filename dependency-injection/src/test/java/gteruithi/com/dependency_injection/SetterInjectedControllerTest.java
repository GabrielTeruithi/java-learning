package gteruithi.com.dependency_injection;

import gteruithi.com.dependency_injection.controllers.SetterInjectedController;
import gteruithi.com.dependency_injection.services.GreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class SetterInjectedControllerTest {

    @Autowired
    SetterInjectedController setterInjectedController;


    @Test
    void sayHello() {
        System.out.println(setterInjectedController.sayHello());
    }
}
