package net.kreckkead.organizationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(info = @Info(title = "Organization Service REST APIs", description = "Organization Service REST APIs Documentation", version = "v1.0", contact = @Contact(name = "Doublecore", email = "greannakub@gmail.com", url = "https://www.kreckkead.xyz"), license = @License(name = "Apache 2.0", url = "https://wwww.kreckkead.xyz")), externalDocs = @ExternalDocumentation(description = "Department-Service Doc", url = "https://wwww.kreckkead.xyz"))
@SpringBootApplication
public class OrganizationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationServiceApplication.class, args);
	}

}
