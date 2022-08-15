package com.devsuperior.uri2621;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2621.dto.ProductMinDTO;
import com.devsuperior.uri2621.projections.ProductProjection;
import com.devsuperior.uri2621.repositories.ProductRepository;

@SpringBootApplication
public class Uri2621Application implements CommandLineRunner {
	
	private static final Logger logger = LoggerFactory.getLogger(Uri2621Application.class);


	@Autowired
	private ProductRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2621Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Resultado em SQL raiz");
		List<ProductProjection> list = repository.search1("p");
		List<ProductMinDTO> dto = list.stream()
				.map(x -> new ProductMinDTO(x))
				.collect(Collectors.toList());
		
		for (ProductMinDTO obj : dto) {
			System.out.println(obj);
		}
		
		logger.info("Resultado em JPQL");
		List<ProductMinDTO> dto2 = repository.search2("p");
		
		for (ProductMinDTO obj : dto2) {
			System.out.println(obj);
		}
	}
}
