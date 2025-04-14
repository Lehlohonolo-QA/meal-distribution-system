package za.ac.uj.meal_distribution_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "za.ac.uj.meal_distribution_system")
@EnableJpaRepositories("za.ac.uj.meal_distribution_system.repository")
@EntityScan("za.ac.uj.meal_distribution_system.model")
@ComponentScan("za.ac.uj.meal_distribution_system")
public class MealDistributionSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MealDistributionSystemApplication.class, args);
	}

}
