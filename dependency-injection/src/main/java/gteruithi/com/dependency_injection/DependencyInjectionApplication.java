package gteruithi.com.dependency_injection;

import gteruithi.com.dependency_injection.controllers.MyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DependencyInjectionApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DependencyInjectionApplication.class, args);
		MyController controller = ctx.getBean(MyController.class);
		System.out.println("I'm in the main method");
		System.out.println(controller.sayHello());
	}

}
