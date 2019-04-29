package com.care.aged.AgedCareArt;

import com.care.aged.AgedCareArt.entity.Doctor;
import com.care.aged.AgedCareArt.entity.Role;
import com.care.aged.AgedCareArt.service.DoctorService;
import com.care.aged.AgedCareArt.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class AgedCareArtApplication implements CommandLineRunner {

	@Autowired
	private IRoleService service;

	@Autowired
	private DoctorService doctorService;


	public static void main(String[] args) {
		SpringApplication.run(AgedCareArtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		service.createRole(new Role("ADMIN", "Administrator"));
		service.createRole(new Role("USER", "User"));


		if(doctorService.findAll().isEmpty()) {
			Doctor doc1 = new Doctor();
			doc1.setDoctorName("Doctor 1");
			doc1.setInfo("Dummy info for doctor 1");


			Doctor doc2 = new Doctor();
			doc2.setDoctorName("Doctor 2");
			doc2.setInfo("Dummy info for doctor 2");

			doctorService.save(doc1);
			doctorService.save(doc2);
		}
	}
}
