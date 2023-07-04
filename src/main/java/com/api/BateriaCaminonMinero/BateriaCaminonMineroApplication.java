package com.api.BateriaCaminonMinero;

import com.api.BateriaCaminonMinero.Models.ERole;
import com.api.BateriaCaminonMinero.Models.EmpresasModel;
import com.api.BateriaCaminonMinero.Models.RolesModel;
import com.api.BateriaCaminonMinero.Models.TrabajadoresModel;
import com.api.BateriaCaminonMinero.Repositories.TrabajadoresRepository;
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
/*
	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	TrabajadoresRepository trabajadoresRepository;

	@Bean
	CommandLineRunner init(){
		return args -> {
			EmpresasModel empresa = new EmpresasModel();
			empresa.setId_emp(1L);
			TrabajadoresModel trabajadoresModel = TrabajadoresModel.builder()
					.nom_tra("Eduardo")
					.ape_tra("Aguilar")
					.dni_tra("78547689")
					.est_tra(true)
					.username("edas22")
					.pass_tra(passwordEncoder.encode("1234"))
					.roles(Set.of(RolesModel.builder()
							.name(ERole.valueOf(ERole.SUPERVISOR.name()))
							.build()))
					.empresasModel(empresa)
					.build();

			trabajadoresRepository.save(trabajadoresModel);

		};
	}*/
}

