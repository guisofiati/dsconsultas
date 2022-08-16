package com.devsuperior.uri2737;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2737.dto.LawyerMinDTO;
import com.devsuperior.uri2737.projections.LawyerMinProjection;
import com.devsuperior.uri2737.repositories.LawyerRepository;

@SpringBootApplication
public class Uri2737Application implements CommandLineRunner {
	
	private static final Logger logger = LoggerFactory.getLogger(Uri2737Application.class);

	@Autowired
	private LawyerRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2737Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Resultado em SQL raiz");
		List<LawyerMinProjection> list = repository.search1();
		List<LawyerMinDTO> dto = list.stream()
				.map(x -> new LawyerMinDTO(x))
				.collect(Collectors.toList());
		
		for (LawyerMinDTO obj : dto) {
			System.out.println(obj);
		}
	}
}
