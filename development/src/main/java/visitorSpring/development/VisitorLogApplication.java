package visitorSpring.development;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import visitorSpring.development.JpaRepo.VisitorJpaRepo;
import visitorSpring.development.Model.Visitor;

@SpringBootApplication
public class VisitorLogApplication implements CommandLineRunner {
	@Autowired
	VisitorJpaRepo visitorJpaRepo;

	public static void main(String[] args) {
		SpringApplication.run(VisitorLogApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Visitor visitor = new Visitor(1, "John", "Smith", "L6T5R4","abc@gmail.com");
		this.visitorJpaRepo.save(visitor);
	}
}
