package ciclo3.grupo18.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	public class HolaMundo {
		@GetMapping("/hola")
		public String saluda(){
			return "<h1>Hola mundo"
		}
	}
}
