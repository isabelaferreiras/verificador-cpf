package sbcpfapi.verificadorcpf.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@ComponentScan({"sbcpfapi.verificadorcpf"})
public class VerificadorCpfApplication {

	public static void main(String[] args) {
		SpringApplication.run(VerificadorCpfApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void startup(){
		System.out.println("App started...");
	}
}
