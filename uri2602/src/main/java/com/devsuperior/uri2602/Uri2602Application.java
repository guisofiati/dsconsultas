package com.devsuperior.uri2602;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2602.dto.CustomerMinDTO;
import com.devsuperior.uri2602.projections.CustomerMinProjection;
import com.devsuperior.uri2602.repositories.CustomerRepository;

@SpringBootApplication
public class Uri2602Application implements CommandLineRunner { // rodar quando executado

	private static final Logger logger = LoggerFactory.getLogger(Uri2602Application.class);
	
	@Autowired
	private CustomerRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2602Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("TESTE");
		
		logger.info("Resultado em SQL raiz");
		
		List<CustomerMinProjection> list = repository.search1("rs");
		List<CustomerMinDTO> result1 = list.stream()
				.map(x -> new CustomerMinDTO(x))
				.collect(Collectors.toList());
		
		for (CustomerMinDTO obj : result1) {
			System.out.println(obj);
		}
		
		logger.info("Resultado em JPQL");

		List<CustomerMinDTO> result2 = repository.search2("rs");
		
		for (CustomerMinDTO obj : result2) {
			System.out.println(obj);
		}
	}
}
