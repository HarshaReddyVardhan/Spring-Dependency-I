package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controllers.*;
import guru.springframework.sfgdi.datasource.FakeDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);
		PetController petController = ctx.getBean("petController", PetController.class);
		System.out.println("--- The Best Pet is ---");
		System.out.println(petController.whichPetIsTheBest());

		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println("----------- I18n");
		System.out.println(i18nController.sayHello());

		MyController myController = (MyController) ctx.getBean("myController");
		System.out.println("----------- Primary Been");
		System.out.println(myController.sayHello());
		System.out.println("----------- Propeerty");
		PropertyInjectedController controller = (PropertyInjectedController) ctx.getBean(
				"propertyInjectedController");
		System.out.println(controller.getGreeting());
		System.out.println("----------- Setter");

		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean(
				"setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());
		System.out.println("----------- Constructor");
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean(
				"constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());

		FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
		System.out.println(fakeDataSource.getUsername());
		System.out.println(fakeDataSource.getPassword());
		System.out.println(fakeDataSource.getJdbcurl());

	}

}
