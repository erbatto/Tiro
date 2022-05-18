package tirocinio.application;


	import org.springframework.boot.SpringApplication;
	import org.springframework.boot.autoconfigure.SpringBootApplication;
	import org.springframework.boot.autoconfigure.domain.EntityScan;
	import org.springframework.context.annotation.ComponentScan;
	import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
	import springfox.documentation.swagger2.annotations.EnableSwagger2;


	

	@EnableSwagger2
	@SpringBootApplication
	@ComponentScan(basePackages={"tirocinio.service","tirocinio.web"})
	@EntityScan(basePackages = {"tirocinio.model"})
	@EnableJpaRepositories(basePackages = {"tirocinio.persistence"})
	public class TirocinioApplication {

		public static void main(String[] args) {
			SpringApplication.run(TirocinioApplication.class, args);
			
			
			
		}
	
	
	}


