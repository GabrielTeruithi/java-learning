package gteruithi.com.dependency_injection.controllers;

import gteruithi.com.dependency_injection.services.GreetingService;
import gteruithi.com.dependency_injection.services.GreetingServiceImpl;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {
    private final GreetingService greetingService;

    public MyController() {
        this.greetingService = new GreetingServiceImpl();
    }

    public String sayHello(){
        System.out.println("I'm in the controller");
        return "Hello Everyone";
    }
}
