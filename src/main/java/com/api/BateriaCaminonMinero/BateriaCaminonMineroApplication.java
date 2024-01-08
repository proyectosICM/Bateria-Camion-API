package com.api.BateriaCaminonMinero;

import com.api.BateriaCaminonMinero.Config.MQTT.MqttSubscriber;
import com.api.BateriaCaminonMinero.Repositories.TrabajadoresRepository;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class BateriaCaminonMineroApplication {

	public static void main(String[] args) {
		//  S
		//  pringApplication.run(BateriaCaminonMineroApplication.class, args);
		ApplicationContext context = SpringApplication.run(BateriaCaminonMineroApplication.class, args);
		MqttSubscriber mqttSubscriber = context.getBean(MqttSubscriber.class);
		// Llama a subscribeToTopic en la instancia
		mqttSubscriber.subscribeToTopic("prueba");
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
			empresa.setId(1L);

			RolesModel rol = new RolesModel();
			rol.setId(1L);

			TrabajadoresModel trabajadoresModel = TrabajadoresModel.builder()
					.nombre("Eduardo")
					.apellido("Aguilar")
					.dni("78547689")
					.estado(true)
					.username("cond")
					.password(passwordEncoder.encode("1234"))
					.rolesModel(rol)
					.empresasModel(empresa)
					.build();

			trabajadoresRepository.save(trabajadoresModel);

		};
	}*/
}

