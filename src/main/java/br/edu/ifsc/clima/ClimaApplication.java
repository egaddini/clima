package br.edu.ifsc.clima;

import br.edu.ifsc.clima.application.menu.Menu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ClimaApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ClimaApplication.class, args);
		Menu menu = context.getBean(Menu.class);
		menu.exibirMenu();
	}

}
