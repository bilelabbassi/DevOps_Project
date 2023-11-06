
package tn.esprit.kaddemproject.configuration;



import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;


@Configuration
public class OpenAPIConfig {

	@Bean
	public OpenAPI springShopOpenAPI() {
		return new OpenAPI()
				.info(infoAPI());

	}

	public Info infoAPI() {
		return new Info().title("devops Projet bilel")
				.description("TP étude de cas")
				.contact(contactAPI());
	}

	public Contact contactAPI() {
		Contact contact = new Contact().name("bilel_abbassi")
				.email("bilel.ab@esprit.tn")
				.url("https://www.linkedin.com/in/atef-maddouri/");
		return contact;
	}


	@Bean
	public GroupedOpenApi contractPublicApi() {
		return GroupedOpenApi.builder()
				.group("Only Contract Management API")
				.pathsToMatch("/contract/**")
				.pathsToExclude("**")
				.build();
	}

	@Bean
	public GroupedOpenApi otherPublicApi() {
		return GroupedOpenApi.builder()
				.group("Other Management API")
				.pathsToMatch("/**")
				.pathsToExclude("/contract/**")
				.build();
	}

}
