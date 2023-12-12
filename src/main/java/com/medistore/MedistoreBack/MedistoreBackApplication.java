package com.medistore.MedistoreBack;

import com.medistore.MedistoreBack.models.Lote;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class MedistoreBackApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MedistoreBackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Lote l = new Lote();
	}
}
