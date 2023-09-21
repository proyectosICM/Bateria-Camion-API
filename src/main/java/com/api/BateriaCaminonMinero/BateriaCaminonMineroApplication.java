package com.api.BateriaCaminonMinero;

import com.api.BateriaCaminonMinero.Models.ERole;
import com.api.BateriaCaminonMinero.Models.EmpresasModel;
import com.api.BateriaCaminonMinero.Models.RolesModel;
import com.api.BateriaCaminonMinero.Models.TrabajadoresModel;
import com.api.BateriaCaminonMinero.Repositories.TrabajadoresRepository;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@SpringBootApplication
public class BateriaCaminonMineroApplication {

	public static void main(String[] args) {
		SpringApplication.run(BateriaCaminonMineroApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI(){
		return new OpenAPI()
				.info(new Info()
						.title("API Gestor de baterias")
						.version("0.11")
						.description("Sample example")
						.termsOfService("http://swagger.io/terms/")
						.license(new License().name("Apache").url("http://springdoc.org"))
				);
	}

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	TrabajadoresRepository trabajadoresRepository;
/*
	@Bean
	CommandLineRunner init(){
		return args -> {
			EmpresasModel empresa = new EmpresasModel();
			empresa.setId_emp(1L);

			RolesModel rol = new RolesModel();
			rol.setId(3L);

			TrabajadoresModel trabajadoresModel = TrabajadoresModel.builder()
					.nom_tra("Eduardo")
					.ape_tra("Aguilar")
					.dni_tra("78547689")
					.estado(true)
					.username("admin")
					.pass_tra(passwordEncoder.encode("1234"))
					.rolesModel(rol)
					.empresasModel(empresa)
					.build();

			trabajadoresRepository.save(trabajadoresModel);

		};
	}*/
}

